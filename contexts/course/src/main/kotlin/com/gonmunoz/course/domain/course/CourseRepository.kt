package com.gonmunoz.course.domain.course

interface CourseRepository {
    fun save(course: Course)
}