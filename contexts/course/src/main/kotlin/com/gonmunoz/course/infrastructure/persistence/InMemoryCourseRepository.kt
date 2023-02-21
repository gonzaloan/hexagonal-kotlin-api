package com.gonmunoz.course.infrastructure.persistence

import com.gonmunoz.course.domain.course.Course
import com.gonmunoz.course.domain.course.CourseRepository

class DatabaseConnectionData(var username: String = "", var password: String = "")
class InMemoryCourseRepository(private val connectionData: DatabaseConnectionData) : CourseRepository {

    init {
        println()
    }

    override fun save(course: Course) {
        TODO("Not yet implemented")
    }
}