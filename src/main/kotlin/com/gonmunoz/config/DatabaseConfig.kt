package com.gonmunoz.config

import com.gonmunoz.course.infrastructure.persistence.DatabaseConnectionData
import com.gonmunoz.course.infrastructure.persistence.InMemoryCourseRepository
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "database.connection")
    fun databaseConnectionData() = DatabaseConnectionData()

    @Bean
    fun courseRepository(databaseConnectionData: DatabaseConnectionData) = InMemoryCourseRepository(databaseConnectionData)
}