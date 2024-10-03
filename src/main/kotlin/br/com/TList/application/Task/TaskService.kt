package br.com.TList.application.Task


import br.com.TList.application.Task.exceptions.TaskNaoEncontradaException
import br.com.TList.domain.task.Task
import br.com.TList.domain.task.TaskRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
abstract class TaskService(
    private val taskRepository: TaskRepository
) {

    fun findAll(): List<Task> {
        return taskRepository.findAll()
    }
    fun findById(taskId: UUID): Task{
        return taskRepository.findById(taskId) ?: throw TaskNaoEncontradaException(taskId)
    }
}