package com.umss.fcyt.classrooms.model.builder.classroom;

import com.umss.fcyt.classrooms.api.response.ClassroomResponse;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.model.domain.PhotoClassroom;
import com.umss.fcyt.classrooms.util.constants.ControllersConstants;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;

public class ClassroomResponseBuilder {
    private final ClassroomResponse instance;

    @Value("${spring.application.url}")
    private String urlApplication;

    public ClassroomResponseBuilder() {
        this.instance = new ClassroomResponse();
    }

    public static ClassroomResponseBuilder getInstance(Classroom request) {
        return (new ClassroomResponseBuilder()).setClassroom(request);
    }

    public ClassroomResponse build() {
        return instance;
    }

    private ClassroomResponseBuilder setClassroom(Classroom request) {
        instance.setId(request.getId());
        instance.setClassroomNumber(request.getClassroomNumber());
        instance.setDescription(request.getDescription());
        instance.setCapacity(request.getCapacity());
        instance.setBuilding(request.getBuilding());
        instance.setLevel(request.getLevel());
        instance.setUrlLocation(request.getUrl());
        instance.setUrlsPhotos(transformPhotoInUrl(request.getPhotos()));
        return this;
    }

    private List<String> transformPhotoInUrl(List<PhotoClassroom> photos) {
        return photos.stream()
                .map(photoClassroom -> urlApplication + ControllersConstants.Api.API + photoClassroom.getId())
                .collect(Collectors.toList());
    }
}
