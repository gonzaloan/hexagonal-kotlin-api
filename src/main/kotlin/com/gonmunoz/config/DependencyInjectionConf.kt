package com.gonmunoz.config

import com.gonmunoz.course.application.CourseCreator
import com.gonmunoz.course.domain.course.CourseRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DependencyInjectionConf {

    @Bean
    fun courseCreator(courseRepository: CourseRepository) = CourseCreator(courseRepository)
}