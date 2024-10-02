package br.com.TList.adapters.jdbc.http

import br.com.TList.application.Task.TaskService
import br.com.TList.domain.task.Task
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class TaskHandler(
    private val taskService: TaskService
) {

    fun findAll(): ResponseEntity<List<Task>> {
        val tasks = taskService.findAll()
        return ResponseEntity.ok(tasks)
    }
}
