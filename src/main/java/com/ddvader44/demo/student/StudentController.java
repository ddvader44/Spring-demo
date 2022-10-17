package com.ddvader44.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    //Autowired - Automatic dependency injection - wires studentservice and gets injected in the constructor
    //Student service class will be the Spring Bean as it needs to get instantiated

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Requests -> GET POST DELETE PUT

    //GetMapping -> Annotation for mapping HTTP GET requests onto specific handler methods.

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //PostMapping -> Annotation for mapping HTTP POST requests onto specific handler methods.
    //RequestBody will get mapped to student

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

}
