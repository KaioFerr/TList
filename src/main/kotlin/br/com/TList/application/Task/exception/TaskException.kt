package br.com.TList.application.Task.exception

import java.util.*

sealed class TaskException(massage: String) : Exception(massage) {
    abstract val taskId: UUID?
}

data class TaskNaoEncontradaException(
    override val taskId: UUID?
): TaskException("Task $taskId não encontrado")