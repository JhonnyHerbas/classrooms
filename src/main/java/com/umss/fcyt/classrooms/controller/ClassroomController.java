package com.umss.fcyt.classrooms.controller;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.api.response.ClassroomResponse;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.service.ClassroomService;
import com.umss.fcyt.classrooms.util.constants.ControllersConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        log.info("Execute create new Classroom.");
        return classroomService.create(createClassroomRequest);
    }

    @PostMapping("/{id}")
    public Classroom uploadLocation(@PathVariable Integer id, @RequestParam String url) {
        log.info("Execute create url location the classroom.");
        return classroomService.uploadLocation(id, url);
    }

    @GetMapping()
    public List<ClassroomResponse> getAllClassrooms() {
        log.info("Execute get all classrooms.");
        return classroomService.getAllClassrooms();
    }
}
