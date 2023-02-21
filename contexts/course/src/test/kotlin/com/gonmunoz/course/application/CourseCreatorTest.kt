package com.gonmunoz.course.application

import com.gonmunoz.course.BaseTest
import com.gonmunoz.course.domain.*
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import java.util.UUID

class CourseCreatorTest : BaseTest() {

    private lateinit var courseRepository: CourseRepository
    private lateinit var courseCreator: CourseCreator

    @BeforeEach
    fun setUp(){
        courseRepository = mockk(relaxUnitFun = true)
        courseCreator = CourseCreator(courseRepository)
    }

    @Test
    fun `should create a course successfully`() {
        givenFixedDate(fixedDate)
        courseCreator.create(id, name)
        thenTheCourseShouldBeSaved()
    }

    @Test
    fun `should fail with invalid id`(){
        givenFixedDate(fixedDate)
        assertThrows<InvalidCourseIdException> { courseCreator.create("Invalid", name)  }
    }

    @Test
    fun `should fail with invalid name`(){
        givenFixedDate(fixedDate)
        assertThrows<InvalidCourseNameException> { courseCreator.create(id, "    ") }
    }
    private fun thenTheCourseShouldBeSaved() {
        verify {
            courseRepository.save(Course.from(
                id,
                name,
                fixedDate
            ))
        }
    }
    companion object {
        private val id = UUID.randomUUID().toString()
        private const val name = "Kotlin Hexagonal Architecture Api Test Course"
        private val fixedDate = LocalDateTime.parse("2023-02-09T14:50:42")
    }
}