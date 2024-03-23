package com.umss.fcyt.classrooms.model.builder.classroom;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.model.domain.Classroom;

public final class ClassroomCreateBuilder {
    private final Classroom instance;

    public ClassroomCreateBuilder() {
        this.instance = new Classroom();
    }

    public static ClassroomCreateBuilder getInstance(CreateClassroomRequest request) {
        return (new ClassroomCreateBuilder()).setClassroom(request);
    }

    public Classroom build() {
        return instance;
    }

    private ClassroomCreateBuilder setClassroom(CreateClassroomRequest request) {
        instance.setClassroomNumber(request.getClassroomNumber());
        instance.setDescription(request.getDescription());
        instance.setCapacity(request.getCapacity());
        instance.setBuilding(request.getBuilding());
        instance.setLevel(request.getLevel());
        return this;
    }
}
