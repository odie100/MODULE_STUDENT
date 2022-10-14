package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.SpecialityRequestDTO;
import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.model.ActivationModel;
import com.akata.studentservice.model.RegistrationStudentModel;
import com.akata.studentservice.model.StudentModel;
import com.akata.studentservice.projections.StudentLightProjection;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface StudentService {
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO getStudent(Long id);

    int update(Long id, StudentModel studentModel);

    int updateCV(String cv_name, Long id);

    boolean delete(Long id);
    List<StudentResponseDTO> getAllStudents();

    StudentLightProjection signIn(String email, String password);

    StudentResponseDTO register(RegistrationStudentModel registrationStudentModel) throws MessagingException;

    String uploadPhoto(MultipartFile photo) throws IOException;

    String uploadDocument(MultipartFile document) throws IOException;

    String uploadVideo(MultipartFile video) throws IOException;

    boolean activate(Long id_user, ActivationModel code);

    boolean updateCurrentPosition(Long id, SpecialityRequestDTO specialityRequestDTO);

    boolean updateGit(Long id, String git);
}
