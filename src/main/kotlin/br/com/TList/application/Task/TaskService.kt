package br.com.TList.application.Task

import br.com.TList.domain.task.Task
import br.com.TList.domain.task.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun findAll(): List<Task> {
        return taskRepository.findAll()
    }
}