package com.umss.fcyt.classrooms.service;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.model.builder.ClassroomBuilder;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.model.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public Classroom create(CreateClassroomRequest createClassroomRequest) {
        Classroom classroom = ClassroomBuilder.getInstance(createClassroomRequest).build();
        return classroomRepository.save(classroom);
    }
}
