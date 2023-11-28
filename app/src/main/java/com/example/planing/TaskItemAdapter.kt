package com.example.planing

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.planing.databinding.ItemsBinding
import com.example.planing.model.Tasks

class TaskItemAdapter (val clickListener:(taskId:Long)->Unit): ListAdapter<Tasks, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TaskItemAdapter.TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemAdapter.TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,clickListener)

    }

   class TaskItemViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tasks,clickListener:(taskId:Long)->Unit) {
binding.tasks=item
            binding.root.setOnClickListener {clickListener(item.taskId )
              //  Toast.makeText(binding.root.context,"${item.taskId}",Toast.LENGTH_LONG).show()
            }

        }

        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                 val binding= ItemsBinding.inflate (layoutInflater,parent,false)
                return TaskItemViewHolder(binding)
            }
        }
    }
}


