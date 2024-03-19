package com.example.demo.student

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/student")
class StudentController(val studentService: StudentService) {
    @GetMapping
    fun getStudents() = studentService.getStudents()

    @PostMapping
    fun registerNewStudent(
        @RequestBody
        student: Student
    ) {
        studentService.addNewStudent(student)
    }

    @PutMapping("/{studentId}")
    fun updateStudent(
        @PathVariable("studentId")
        studentId: Long,
        @RequestBody
        studentData: Student
    ) {
        studentService.updateStudent(studentId, studentData)
    }

    @DeleteMapping("/{studentId}")
    fun deleteStudent(
        @PathVariable("studentId")
        studentId: Long
    ) {
        studentService.deleteStudent(studentId)
    }
}