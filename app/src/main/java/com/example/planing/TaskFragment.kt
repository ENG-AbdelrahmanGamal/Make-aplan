package com.example.planing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.planing.databinding.FragmentTaskBinding
import com.example.planing.model.TaskDao
import com.example.planing.model.TaskDataBase
import com.example.planing.viewModel.TasksViewModel
import com.example.planing.viewModel.TasksViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.lifecycleOwner = viewLifecycleOwner
        val application = requireNotNull(this.activity).application
        val dao = TaskDataBase.getInstance(application).taskDao
        val viewModelFactory = TasksViewModelFactory(dao)
        var viewModel = ViewModelProvider(this, viewModelFactory).get(TasksViewModel::class.java)
        binding.viewModel = viewModel

        val adapter=TaskItemAdapter{taskId ->Toast.makeText(context,"Clicked task $taskId",Toast.LENGTH_LONG).show()  }
        binding.rvTasksList.adapter=adapter
viewModel.tasks.observe(viewLifecycleOwner, Observer {
    it?.let { adapter.submitList(it) }
})

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}