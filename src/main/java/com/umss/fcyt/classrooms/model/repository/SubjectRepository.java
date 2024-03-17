package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
