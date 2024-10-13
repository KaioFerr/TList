package br.com.TList.adapters.jdbc.http

import br.com.TList.application.Task.TaskCreateCommand
import br.com.TList.application.Task.TaskService
import br.com.TList.domain.task.Task
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TaskHandler(
    private val taskService: TaskService
) {

    fun findAll(): ResponseEntity<List<Task>> {
        val tasks = taskService.findAll()
        return ResponseEntity.ok(tasks)
    }

    fun findById(taskId: String): ResponseEntity<Task> {
        val task = taskService.findById(UUID.fromString(taskId))
        return ResponseEntity.ok(task)
    }

    fun insert(taskCreateCommand: TaskCreateCommand): ResponseEntity<Task>{
        val task = taskService.insert(taskCreateCommand)
        return ResponseEntity.status(HttpStatus.CREATED).body(task)
    }
}
