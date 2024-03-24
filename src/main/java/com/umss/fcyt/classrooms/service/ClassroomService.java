package com.umss.fcyt.classrooms.service;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.api.response.ClassroomResponse;
import com.umss.fcyt.classrooms.model.builder.classroom.ClassroomCreateBuilder;
import com.umss.fcyt.classrooms.model.builder.classroom.ClassroomResponseBuilder;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.model.domain.PhotoClassroom;
import com.umss.fcyt.classrooms.model.repository.ClassroomRepository;
import com.umss.fcyt.classrooms.model.repository.PhotoClassroomRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final PhotoClassroomRepository photoClassroomRepository;

    public ClassroomService(
            ClassroomRepository classroomRepository,
            PhotoClassroomRepository photoClassroomRepository
    ) {
        this.classroomRepository = classroomRepository;
        this.photoClassroomRepository = photoClassroomRepository;
    }

    public Classroom create(CreateClassroomRequest createClassroomRequest) {
        Classroom newClassroom = ClassroomCreateBuilder.getInstance(createClassroomRequest).build();
        return classroomRepository.save(newClassroom);
    }

    public Classroom uploadLocation(Integer id, String url) {
        Optional<Classroom> classroomOptional = classroomRepository.findById(id);
        if (classroomOptional.isPresent()) {
            Classroom classroom = classroomOptional.get();
            classroom.setUrl(url);
            return classroomRepository.save(classroom);
        } else {
            throw new RuntimeException("Classroom not found.");
        }
    }

    public List<ClassroomResponse> getAllClassrooms() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream()
                .map(classroom -> ClassroomResponseBuilder.getInstance(classroom).build())
                .collect(Collectors.toList());
    }

    public ClassroomResponse uploadPhoto(Integer classroomId, MultipartFile photo) {
        String fileBase64 = convertFileToBase64(photo);
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Not found Classroom."));
        PhotoClassroom newPhoto = new PhotoClassroom();
        newPhoto.setClassroom(classroom);
        newPhoto.setImage(fileBase64);
        PhotoClassroom photoSaved = photoClassroomRepository.save(newPhoto);
        classroom.getPhotos().add(photoSaved);
        return ClassroomResponseBuilder.getInstance(classroomRepository.save(classroom)).build();
    }

    private String convertFileToBase64(MultipartFile photo) {
        try {
            return new String(Base64.encodeBase64(photo.getBytes(), false));
        } catch (IOException e) {
            throw new RuntimeException("Error to convert avatar to Base64.");
        }
    }

    public byte[] getClassroomPhoto(Integer photoId) {
        PhotoClassroom photoClassroom = photoClassroomRepository.findById(photoId)
                .orElseThrow(() -> new RuntimeException("Not found image."));
        return java.util.Base64.getDecoder().decode(photoClassroom.getImage());
    }
}
