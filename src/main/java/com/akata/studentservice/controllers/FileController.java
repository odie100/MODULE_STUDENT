package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.FileResponseDTO;
import com.akata.studentservice.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(path = "/api/file")
public class FileController {

    /*@Autowired
    private FileStorageService fileStorageService;

    @PutMapping()
    public ResponseEntity<FileResponseDTO> uploadFile(@RequestParam("file") MultipartFile file){
        String filename = fileStorageService.storeFile(file);
        String download_uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(filename)
                .toUriString();

        FileResponseDTO fileResponseDTO = new FileResponseDTO(filename, download_uri, file.getContentType(), file.getSize());

        return  new ResponseEntity<FileResponseDTO>(fileResponseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String file_name, HttpServletRequest request){
        Resource resource = fileStorageService.loadFile(file_name);
        String content = null;
        try {
            content = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException e){
            System.out.println("Could not determine file type");
        }

        if(content == null){
            content = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(content)).body(resource);
    }*/
}
