package br.com.TList.application.Task


import br.com.TList.application.Task.exception.TaskNaoEncontradaException
import br.com.TList.domain.task.Task
import br.com.TList.domain.task.TaskRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun findAll(): List<Task> {
        return taskRepository.findAll()
    }
    fun findById(taskId: UUID): Task{
        return taskRepository.findById(taskId) ?: throw TaskNaoEncontradaException(taskId)
    }
    fun insert(task: TaskCreateCommand): Task{
        val taskDomain = task.toTask()
        taskRepository.insert(task = taskDomain)
        return findById(taskDomain.id)
    }

    fun update(task: TaskUpdateCommand, taskId: UUID): Task {
        taskRepository.findById(taskId = taskId) ?: throw TaskNaoEncontradaException(taskId)
        taskRepository.update(task.toTask(taskId))
        return findById(taskId = taskId)
    }

    fun delete(taskId: UUID){
        taskRepository.findById(taskId = taskId) ?: throw TaskNaoEncontradaException(taskId)
        taskRepository.delete(taskId)
    }
}