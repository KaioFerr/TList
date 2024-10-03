package br.com.TList.adapters.jdbc

object TaskSQLExpressions {
    fun sqlSelectAll() = """
        SELECT id,
               title,
               description,
               due_date,
               status,
               priority,
               created_at,
               updated_at
        FROM tasks
    """.trimIndent()

    fun sqlSelectById() = """
        SELECT id,
               title,
               description,
               due_date,
               status,
               priority,
               created_at,
               updated_at
        FROM tasks
        WHERE tasks.id = :id
    """.trimIndent()
}