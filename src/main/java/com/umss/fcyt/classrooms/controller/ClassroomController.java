package com.umss.fcyt.classrooms.controller;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.service.ClassroomService;
import com.umss.fcyt.classrooms.util.constants.ControllersConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ControllersConstants.Api.API + "/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping()
    public Classroom createClassroom(@RequestBody CreateClassroomRequest createClassroomRequest) {
        log.info("Execute create new Classroom");
        return classroomService.create(createClassroomRequest);
    }
}
