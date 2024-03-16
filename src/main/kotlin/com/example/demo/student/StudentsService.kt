package com.example.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Month

@Service
class StudentService(
    @Autowired
    private val studentRepository: StudentRepository
) {
    // Student(1, "Pepe", "pepe@example.com", LocalDate.of(2000, Month.JANUARY, 5), 24)
    fun getStudents() = studentRepository.findAll()
}