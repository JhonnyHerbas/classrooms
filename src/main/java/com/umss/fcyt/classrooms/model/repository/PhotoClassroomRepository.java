package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.PhotoClassroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoClassroomRepository extends JpaRepository<PhotoClassroom, Integer> {
}
