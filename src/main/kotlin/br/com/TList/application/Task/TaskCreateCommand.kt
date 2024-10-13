package br.com.TList.application.Task

import br.com.TList.domain.task.Task
import java.util.*
import kotlinx.serialization.Serializable

@Serializable
data class TaskCreateCommand(
    val title: String,
    val description: String,
    val due_date: String,
    val status: String,
    val priority: String,
    val created_at: String,
    val updated_at: String,
)

//metodo de extensão
fun TaskCreateCommand.toTask() = Task(
    title = title,
    description = description,
    due_date = due_date,
    status = status,
    priority = priority,
    created_at = created_at,
    updated_at = updated_at,
)
