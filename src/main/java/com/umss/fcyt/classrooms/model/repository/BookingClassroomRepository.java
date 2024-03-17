package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.BookingClassroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingClassroomRepository extends JpaRepository<BookingClassroom, Integer> {
}
