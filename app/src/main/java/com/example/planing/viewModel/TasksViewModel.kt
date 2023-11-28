package com.example.planing.viewModel


import androidx.lifecycle.ViewModel
//import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.planing.model.TaskDao
import com.example.planing.model.Tasks
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao) : ViewModel() {
    var newtask = ""
    val tasks = dao.getAll()

    fun addTask() {
        viewModelScope.launch {
            val task = Tasks()
            task.taskName = newtask
            dao.insert(task)
        }
    }
}