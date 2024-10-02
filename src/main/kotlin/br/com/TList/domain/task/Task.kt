package br.com.TList.domain.task

import java.util.*

class Task(
    val id: UUID = UUID.randomUUID(),
    title: String,
    description: String,
    due_date: String,
    status: String,
    priority: String,
    updated_at: String
)