package com.gonmunoz.course.application

import com.gonmunoz.course.domain.Clock
import com.gonmunoz.course.domain.course.Course
import com.gonmunoz.course.domain.course.CourseId
import com.gonmunoz.course.domain.course.CourseName
import com.gonmunoz.course.domain.course.CourseRepository

// This is the UseCase
class CourseCreator(private val repository: CourseRepository, private val clock: Clock) {

    fun create(id: String, name: String) {
        Course(
            CourseId.fromString(id), CourseName(name), clock.now()
        ).let {
            repository.save(it)
        }
    }
}