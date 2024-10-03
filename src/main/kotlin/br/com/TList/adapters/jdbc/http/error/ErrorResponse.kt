package br.com.TList.adapters.jdbc.http.error

import java.util.*

data class ErrorResponse(
    val id: UUID? = null,
    val message: String,
) {
}