package br.com.TList.adapters.jdbc.http

import br.com.TList.application.Task.TaskCreateCommand
import br.com.TList.domain.task.Task
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

private const val UUID_REGEX = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}"

@RestController
class TaskController(
    private val taskHandler: TaskHandler
) {
    @GetMapping("/tasks")
    fun findAll(): ResponseEntity<List<Task>>{
        return taskHandler.findAll()
    }

    @GetMapping("/tasks/{taskId:$UUID_REGEX}")
    fun findById(@PathVariable taskId: String) : ResponseEntity<Task>{
        return taskHandler.findById(taskId)
    }

    @PostMapping("/task")
    fun insert(@RequestBody task: TaskCreateCommand): ResponseEntity<Task>{
        return taskHandler.insert(task)
    }
}