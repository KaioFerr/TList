package br.com.TList.application.Task

import br.com.TList.domain.task.Task
import kotlinx.serialization.Serializable
import java.sql.Timestamp
import java.time.LocalDate

@Serializable
data class TaskCreateCommand(

    val title: String,
    val description: String,
    val due_date: LocalDate,
    val status: String,
    val priority: Int,

)

//metodo de extensão
fun TaskCreateCommand.toTask() = Task(

    title = title,
    description = description,
    due_date = due_date,
    status = status,
    priority = priority,

)
