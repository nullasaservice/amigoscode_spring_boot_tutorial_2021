package com.example.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class StudentService(
    @Autowired
    private val studentRepository: StudentRepository
) {
    fun getStudents() = studentRepository.findAll()
    fun addNewStudent(student: Student) {
        var studentByEmail = studentRepository.findStudentByEmail(student.email)

        if (studentByEmail.isPresent) throw IllegalStateException("Email is already taken")

        studentRepository.save(student)
    }
}