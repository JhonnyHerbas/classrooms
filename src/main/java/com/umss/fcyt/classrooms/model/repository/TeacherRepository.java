package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
