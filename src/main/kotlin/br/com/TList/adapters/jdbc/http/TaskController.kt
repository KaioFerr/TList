package br.com.TList.adapters.jdbc.http

import br.com.TList.domain.task.Task
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
    private val taskHandler: TaskHandler
) {
    @GetMapping("/tasks")
    fun findAll(): ResponseEntity<List<Task>>{
        return taskHandler.findAll()
    }
}