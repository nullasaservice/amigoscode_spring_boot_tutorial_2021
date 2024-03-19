package com.example.demo.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class StudentConfig {
    @Bean
    fun commandLineRunner(repository: StudentRepository): CommandLineRunner {
        return CommandLineRunner { args ->
            var pepe = Student("Pepe", "pepe@example.com", LocalDate.of(2000, Month.JANUARY, 5), 24)

            var manolo = Student("Manolo", "manolo@example.com", LocalDate.of(2001, Month.MARCH, 7), 23)

            repository.saveAll(listOf(pepe, manolo))
        }
    }
}