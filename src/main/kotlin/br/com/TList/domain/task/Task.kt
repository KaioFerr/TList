package br.com.TList.domain.task

import java.util.*

class Task(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val due_date: String,
    val status: String,
    val priority: String,
    val created_at: String,
    val updated_at: String
)