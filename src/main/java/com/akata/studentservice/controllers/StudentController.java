package com.akata.studentservice.controllers;


import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.StudentModel;
import com.akata.studentservice.services.FileStorageService;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(path = "/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return this.studentService.uploadPhoto(file);
    }

    @PostMapping(path = "/upload/file/{id}")
    public String uploadDocument(@RequestParam("document") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        String cv_name = this.studentService.uploadDocument(file);
        this.studentService.updateCV(cv_name, id);
        return cv_name;
    }

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

    @GetMapping(path = "/images/{filename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource load (@PathVariable String filename) throws IOException {
       return this.fileStorageService.loadFile(filename);
    }

    @GetMapping(path = "/download/document/{filename}", produces = MediaType.ALL_VALUE)
    public Resource downloadDocument(@PathVariable String filename) throws IOException {
        return this.fileStorageService.loadDocument(filename);
    }
}
