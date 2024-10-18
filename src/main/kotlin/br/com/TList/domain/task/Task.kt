package br.com.TList.domain.task

import java.sql.Timestamp
import java.time.LocalDate
import java.util.*

class Task(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val due_date: LocalDate,
    val status: String,
    val priority: Int,

)