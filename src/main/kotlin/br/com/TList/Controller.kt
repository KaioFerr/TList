package br.com.TList

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class Controller (
    private val namedParameterJdbcOperations: NamedParameterJdbcOperations
) {

    @GetMapping("/ping")
    fun ping(): String {
        return "pong";
    }
    @GetMapping("/lista")
    fun list(): List<User>{
//        val toDoList = listOf(
//            ToDoList(
//                    id = UUID.randomUUID(),
//            name = "Tarefa 01",
//            description = "Ir ao mercado"
//        ),
//        ToDoList(
//            id = UUID.randomUUID(),
//            name = "Tarefa 02",
//            description = "Estudar algoritmo"
//        )
//        )

        val users = namedParameterJdbcOperations.query("select id, username, email, password from users", {
            rs, rows ->
            User(
                id = UUID.fromString(rs.getString("id")),
                username = rs.getString("username"),
                email = rs.getString("email"),
                password = rs.getString("password")

            )
        })

        return users
    }
}