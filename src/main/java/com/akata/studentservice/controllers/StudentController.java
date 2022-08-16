package com.akata.studentservice.controllers;


import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.StudentModel;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/insert")
    public StudentResponseDTO save(@RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.save(studentRequestDTO);
    }

    @GetMapping(path = "/all")
    public List<StudentResponseDTO> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public StudentResponseDTO getById(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return studentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody StudentModel studentModel){
        return studentService.update(id,studentModel);
    }
}
