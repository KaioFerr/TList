package br.com.TList.adapters.jdbc

object TaskSQLExpressions {
    fun sqlSelectAll() = """
        SELECT id,
               title,
               description,
               due_date,
               status,
               priority               
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

    fun sqlInsertTask() = """
        INSERT INTO tasks (
            id,
            title,
            description,
            due_date,
            status,
            priority            
        ) VALUES (
            :id,
            :title,
            :description,
            :due_date,
            :status,
            :priority
        )
    """.trimIndent()
}


fun sqlUpdateTask() = """
    UPDATE tasks
            set 
                title = :title,
                description = :description,
                due_date = :due_date,
                status = :status,
                priority = :priority           
        WHERE id = :id
    """.trimIndent()




//fun delete() = """
//    DELETE
//    FROM tasks
//    where id = :id
//""".trimIndent()