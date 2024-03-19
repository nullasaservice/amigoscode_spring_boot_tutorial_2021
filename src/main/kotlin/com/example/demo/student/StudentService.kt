package com.example.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService(
    @Autowired
    private val studentRepository: StudentRepository
) {
    fun getStudents() = studentRepository.findAll()
    fun addNewStudent(student: Student) {
        println(student)
    }
}