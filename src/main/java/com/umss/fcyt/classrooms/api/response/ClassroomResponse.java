package com.umss.fcyt.classrooms.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassroomResponse {
    private Integer id;
    private String classroomNumber;
    private String description;
    private Integer capacity;
    private String building;
    private Integer level;
    private String urlLocation;
    private List<String> urlsPhotos;
}
