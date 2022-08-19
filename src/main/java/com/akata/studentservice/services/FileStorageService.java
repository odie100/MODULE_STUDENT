package com.akata.studentservice.services;

import com.akata.studentservice.configuration.FileStorageProperties;
import com.akata.studentservice.exception.FileStorageException;
import com.akata.studentservice.exception.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    /*private final Path  file_storage_location;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties){
        this.file_storage_location = Paths.get(fileStorageProperties.getUpload_dir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.file_storage_location);
        }catch (Exception e){
            throw new FileStorageException("Could not create the directory upload");
        }
    }

    public String storeFile(MultipartFile file){
        String file_name = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path targe_location = this.file_storage_location.resolve(file_name);
            Files.copy(file.getInputStream(), targe_location, StandardCopyOption.REPLACE_EXISTING);
            return file_name;
        }catch (IOException e){
            throw new FileStorageException("Could not store file "+file_name+". Please try again !");
        }
    }

    public Resource loadFile(String file_name){
        try {
            Path file_path = this.file_storage_location.resolve(file_name).normalize();
            Resource resource = new UrlResource(file_path.toUri());
            if(resource.exists()){
                return resource;
            }else{
                throw  new MyFileNotFoundException("File not found "+file_name);
            }
        }catch (MalformedURLException e){
            throw  new MyFileNotFoundException("File not found "+file_name);
        }
    }*/
}
