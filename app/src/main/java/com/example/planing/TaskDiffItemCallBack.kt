package com.example.planing

import androidx.recyclerview.widget.DiffUtil
import com.example.planing.model.Tasks

class TaskDiffItemCallBack:DiffUtil.ItemCallback<Tasks>() {
    override fun areItemsTheSame(oldItem: Tasks, newItem: Tasks)=(oldItem.taskId==newItem.taskId)

    override fun areContentsTheSame(oldItem: Tasks, newItem: Tasks)=(oldItem==newItem)



}