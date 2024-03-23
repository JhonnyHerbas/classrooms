package com.umss.fcyt.classrooms.service;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.api.response.ClassroomResponse;
import com.umss.fcyt.classrooms.model.builder.classroom.ClassroomCreateBuilder;
import com.umss.fcyt.classrooms.model.builder.classroom.ClassroomResponseBuilder;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.model.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
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
        }else {
            throw new RuntimeException("Classroom not found.");
        }
    }

    public List<ClassroomResponse> getAllClassrooms() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream()
                .map(classroom -> ClassroomResponseBuilder.getInstance(classroom).build())
                .collect(Collectors.toList());
    }
}
