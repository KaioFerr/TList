package br.com.TList.domain.task

import java.util.*


interface TaskRepository {
    fun findAll(): List<Task>

    fun findById(taskId: UUID): Task?
}