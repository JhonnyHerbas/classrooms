package com.umss.fcyt.classrooms.api.request.classroom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClassroomRequest {
    private String classroomNumber;
    private String description;
    private Integer capacity;
    private String building;
    private Integer level;
}
