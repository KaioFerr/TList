package br.com.TList.adapters.jdbc

import br.com.TList.adapters.jdbc.TaskSQLExpressions.sqlSelectAll
import br.com.TList.adapters.jdbc.TaskSQLExpressions.sqlSelectById
import br.com.TList.domain.task.Task
import br.com.TList.domain.task.TaskRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*
import javax.swing.tree.RowMapper

@Repository
class taskJDBCRepository(
    private val db: NamedParameterJdbcOperations
) : TaskRepository {
    override fun findAll(): List<Task> {
        val tasks = db.query(sqlSelectAll(), rowMapper())
        return tasks
    }

    override fun findById(idTask: UUID): Task? {
        val params = MapSqlParameterSource("id", idTask)
        val task = db.query(sqlSelectById(), params, rowMapper()).firstOrNull()
        return task
    }

    private fun rowMapper() = org.springframework.jdbc.core.RowMapper<Task> { rs, _ ->
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
    }
}