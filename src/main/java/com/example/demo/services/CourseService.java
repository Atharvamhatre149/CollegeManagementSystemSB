package com.example.demo.services;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository CourseRepository;


    public List<Course> getAllCourses() {
        return CourseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return CourseRepository.findById(id);
    }

    public Course createCourse(Course Course) {
        return CourseRepository.save(Course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> existingCourse = CourseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course Course = existingCourse.get();
            Course.setName(updatedCourse.getName());
            Course.setEnrollcount(updatedCourse.getEnrollcount());
            return CourseRepository.save(Course);
        }
        return null;
    }

    public boolean deleteCourse(Long id) {
        Optional<Course> existingCourse = CourseRepository.findById(id);
        if (existingCourse.isPresent()) {
            CourseRepository.delete(existingCourse.get());
            return true;
        }
        return false;
    }

    public void deleteAllCourse() {
    
        CourseRepository.deleteAll();
        
    }
}
