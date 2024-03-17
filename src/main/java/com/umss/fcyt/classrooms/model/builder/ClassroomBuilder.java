package com.umss.fcyt.classrooms.model.builder;

import com.umss.fcyt.classrooms.api.request.classroom.CreateClassroomRequest;
import com.umss.fcyt.classrooms.model.domain.Classroom;

public final class ClassroomBuilder {
    private final Classroom instance;

    public ClassroomBuilder() {
        this.instance = new Classroom();
    }

    public static ClassroomBuilder getInstance(CreateClassroomRequest request) {
        return (new ClassroomBuilder()).setClassroom(request);
    }

    public Classroom build() {
        return instance;
    }

    private ClassroomBuilder setClassroom(CreateClassroomRequest request) {
        instance.setClassroomNumber(request.getClassroomNumber());
        instance.setDescription(request.getDescription());
        instance.setCapacity(request.getCapacity());
        instance.setBuilding(request.getBuilding());
        instance.setLevel(request.getLevel());
        return this;
    }
}
