package com.example.planing.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface TaskDao {
    @Insert
  suspend  fun insert(tasks: Tasks)

    @Delete
   suspend fun delete(tasks: Tasks)
    @Update
 suspend   fun update(tasks: Tasks)
@Query("select * from task_table order by taskId DESC")
 fun getAll():LiveData<List<Tasks>>

}