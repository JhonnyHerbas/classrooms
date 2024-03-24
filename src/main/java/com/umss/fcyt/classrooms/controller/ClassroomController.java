package com.umss.fcyt.classrooms.controller;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.api.response.ClassroomResponse;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.service.ClassroomService;
import com.umss.fcyt.classrooms.util.constants.ControllersConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/{id}/upload-url-location")
    public Classroom uploadLocation(@PathVariable Integer id, @RequestParam String url) {
        log.info("Execute create url location the classroom.");
        return classroomService.uploadLocation(id, url);
    }

    @GetMapping()
    public List<ClassroomResponse> getAllClassrooms() {
        log.info("Execute get all classrooms.");
        return classroomService.getAllClassrooms();
    }

    @PostMapping(value = "/{classroomId}/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ClassroomResponse uploadPhoto(@PathVariable Integer classroomId, @RequestBody MultipartFile photo) {
        log.info("Execute upload image the classroom.");
        return classroomService.uploadPhoto(classroomId, photo);
    }

    @GetMapping(value = "/{photoId}/get-photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Integer photoId) {
        log.info("Execute get photo.");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(classroomService.getClassroomPhoto(photoId), headers, HttpStatus.OK);
    }
}
