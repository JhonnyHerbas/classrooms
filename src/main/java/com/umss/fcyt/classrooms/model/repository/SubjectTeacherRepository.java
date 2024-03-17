package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.SubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher, Integer> {
}
