package com.gonmunoz.course.application

import com.gonmunoz.course.domain.course.Course
import com.gonmunoz.course.domain.course.CourseId
import com.gonmunoz.course.domain.course.CourseName
import com.gonmunoz.course.domain.course.CourseRepository
import java.time.LocalDateTime

// This is the UseCase
class CourseCreator(private val repository: CourseRepository) {

    fun create(id: String, name: String) {
        Course(CourseId.fromString(id), CourseName(name), LocalDateTime.now()).let {
            repository.save(it)
        }
    }
}