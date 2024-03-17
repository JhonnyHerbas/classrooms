package com.umss.fcyt.classrooms.model.repository;

import com.umss.fcyt.classrooms.model.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
