package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Teacher;
import com.example.demo.services.TeacherService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;


    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id)  {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teacher> createStudent(@RequestBody Teacher teacher) {
        Teacher createdStudent = teacherService.createStudent(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateStudent(
            @PathVariable Long id, @RequestBody Teacher updatedStudent) {
        Teacher student = teacherService.updateStudent(id, updatedStudent);
        return student != null
                ? ResponseEntity.ok(student)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public  ResponseEntity<Void> deleteAllTeacher(){
        teacherService.deleteAllTeacher();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(null);
    }

}
