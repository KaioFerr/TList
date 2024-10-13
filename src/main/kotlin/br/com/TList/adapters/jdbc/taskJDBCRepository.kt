package br.com.TList.adapters.jdbc

import br.com.TList.adapters.jdbc.TaskSQLExpressions.sqlInsertTask
import br.com.TList.adapters.jdbc.TaskSQLExpressions.sqlSelectAll
import br.com.TList.adapters.jdbc.TaskSQLExpressions.sqlSelectById
import br.com.TList.domain.task.Task
import br.com.TList.domain.task.TaskRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class taskJDBCRepository(
    private val db: NamedParameterJdbcOperations
) : TaskRepository {
    private companion object{
        val LOGGER = KotlinLogging.logger { }
    }

    override fun findAll(): List<Task> {
        val tasks = try {
            db.query(sqlSelectAll(), rowMapper())
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar as tarefas: ${ex.message}" }
            throw ex
        }
        return tasks
    }

    override fun findById(taskId: UUID): Task? {

        val task = try {
            val params = MapSqlParameterSource("id", taskId)
            db.query(sqlSelectById(), params, rowMapper()).firstOrNull()
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar a tarefa: ${ex.message}" }
            throw ex
        }
        return task
    }

    override fun insert(task: Task): Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("id", task.id)
            params.addValue("title", task.title)
            params.addValue("description", task.description)
            params.addValue("due_date", task.due_date)
            params.addValue("status", task.status)
            params.addValue("priority", task.priority)
            val linhasAfetadas = db.update(sqlInsertTask(), params)
            return linhasAfetadas > 0
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao inserir o produto: ${ex.message}" }
            throw ex
        }
    }

    private fun rowMapper() = RowMapper<Task>{ rs, _ ->
        val taskId = UUID.fromString(rs.getString("id"))
        Task(
            id = taskId,
            title = rs.getString("title"),
            description = rs.getString("description"),
            due_date = rs.getString("due_date"),
            status = rs.getString("status"),
            priority = rs.getString("priority"),
            created_at = rs.getString("created_at"),
            updated_at = rs.getString("updated_at")
        )
    }
}