package com.gonmunoz.course.application

import com.gonmunoz.course.domain.Course
import com.gonmunoz.course.domain.CourseRepository
import java.time.LocalDateTime
import java.util.*

class CourseCreator(private val repository: CourseRepository) {

    fun create(id: String, name: String) {
        Course(UUID.fromString(id), name, LocalDateTime.now()).let {
            repository.save(it)
        }
    }
}