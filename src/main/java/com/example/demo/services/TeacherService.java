package com.example.demo.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher createStudent(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateStudent(Long id, Teacher updatedTeacher) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isPresent()) {
            Teacher teacher = existingTeacher.get();
            teacher.setName(updatedTeacher.getName());
            teacher.setAge(updatedTeacher.getAge());
            teacher.setSalary(updatedTeacher.getSalary());
            teacher.setSpecification(updatedTeacher.getSpecification());

            return teacherRepository.save(teacher);
        }
        return null;
    }

    public boolean deleteTeacher(Long id) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isPresent()) {
            teacherRepository.delete(existingTeacher.get());
            return true;
        }
        return false;
    }

    public void deleteAllTeacher() {
    
        teacherRepository.deleteAll();
        
    }
}
