package br.com.TList

import org.springframework.context.annotation.Description
import java.util.UUID

class Product(
    val id: UUID,
    val name: String,
    val description: String
)