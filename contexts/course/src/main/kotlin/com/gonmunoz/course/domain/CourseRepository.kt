package com.gonmunoz.course.domain

interface CourseRepository {
    fun save(course: Course)
}