package br.com.TList.domain.task


interface TaskRepository {
    fun findAll(): List<Task>
}