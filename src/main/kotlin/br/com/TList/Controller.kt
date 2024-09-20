package br.com.TList

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class Controller {

    @GetMapping("/ping")
    fun ping(): String {
        return "pong";
    }
    @GetMapping("/produtos")
    fun produtos(): List<Product>{
        /*val products = listOf(
            Product(
                id = UUID.randomUUID(),
                name = "Produto 01",
                description = "O produto é muito bom"
            ),
            Product(
                id = UUID.randomUUID(),
                name = "Produto 02",
                description = "O produto é muito bom"
            )
        )
        return products*/
    }
}