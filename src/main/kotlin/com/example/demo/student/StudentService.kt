package com.example.demo.student

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.IllegalStateException

@Service
class StudentService(
    @Autowired
    private val studentRepository: StudentRepository
) {
    fun getStudents() = studentRepository.findAll()
    fun addNewStudent(student: Student) {
        var studentByEmail = studentRepository.findStudentByEmail(student.email)

        if (studentByEmail.isPresent)
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Email is already taken")

        studentRepository.save(student)
    }
    @Transactional
    fun updateStudent(studentId: Long, studentData: Student) {
        val studentEmail = studentData.email

        // Validation checks
        if (studentData.name.isEmpty())
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Name cannot be empty")
        if (studentEmail.isEmpty())
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Email cannot be empty")
        if (studentRepository.findStudentByEmail(studentEmail).isPresent)
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Email is already taken")

        var studentQuery = studentRepository.findById(studentId)

        if (studentQuery.isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")

        var student = studentQuery.get()

        student.name = studentData.name
        student.email = studentData.email
    }
    fun deleteStudent(studentId: Long) {
        if (!studentRepository.existsById(studentId))
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")

        studentRepository.deleteById(studentId)
    }
}