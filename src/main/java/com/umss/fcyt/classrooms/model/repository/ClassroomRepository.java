package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
