package br.com.TList.domain.task

import java.util.*


interface TaskRepository {
    fun findAll(): List<Task>

    fun findById(taskId: UUID): Task?

    fun insert(task: Task): Boolean

    fun update(task: Task): Boolean

    fun delete(taskId: UUID): Boolean
}