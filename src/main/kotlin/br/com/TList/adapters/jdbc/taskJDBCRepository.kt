package br.com.TList.adapters.jdbc

import br.com.TList.adapters.jdbc.TaskSQLExpressions.sqlSelectAll
import br.com.TList.domain.task.Task
import br.com.TList.domain.task.TaskRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class taskJDBCRepository(
    private val db: NamedParameterJdbcOperations
) : TaskRepository {
    override fun findAll(): List<Task> {
        val tasks = db.query(sqlSelectAll(), { rs, _ ->
            val taskId = UUID.fromString(rs.getString("id"))
            Task(
                id = taskId,
                title = rs.getString("title"),
                description = rs.getString("description"),
                due_date = rs.getString("due_date"),
                status = rs.getString("status"),
                priority = rs.getString("priority"),
                updated_at = rs.getString("updated_at")
            )
        })
        return println(task)
    }
}
