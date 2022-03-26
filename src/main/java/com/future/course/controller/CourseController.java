package com.future.course.controller;

import com.future.course.interfaces.CourseRepository;
import com.future.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/")
    public String getCourseAppHome(){
        return ("Course App Home");
    }

    @RequestMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Course getCourseById(@PathVariable("id") BigInteger id){
        return courseRepository.getById(id);
    }


    @RequestMapping(method= RequestMethod.POST, value="/courses")
    public void saveCourse(@RequestBody Course course){
        courseRepository.save(course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void deleteCourse(@PathVariable BigInteger id){
        courseRepository.deleteById(id);

    }
}
