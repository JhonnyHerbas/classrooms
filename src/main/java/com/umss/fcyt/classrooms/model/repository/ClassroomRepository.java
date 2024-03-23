package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    List<Classroom> findByIdIn(List<Integer> classroomIds);
}
