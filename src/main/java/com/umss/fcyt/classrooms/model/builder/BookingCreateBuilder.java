package com.umss.fcyt.classrooms.model.builder;

import com.umss.fcyt.classrooms.api.request.booking.CreateBookingRequest;
import com.umss.fcyt.classrooms.model.domain.Booking;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.model.domain.SubjectTeacher;
import com.umss.fcyt.classrooms.util.constants.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public class BookingCreateBuilder {
    private final Booking instance;

    public BookingCreateBuilder() {
        this.instance = new Booking();
    }

    public static BookingCreateBuilder getInstance(
            CreateBookingRequest request,
            SubjectTeacher subjectTeacher,
            List<Classroom> classrooms
    ) {
        return (new BookingCreateBuilder()).setBooking(request, subjectTeacher, classrooms);
    }

    public Booking build() {
        return instance;
    }

    public BookingCreateBuilder setBooking(
            CreateBookingRequest request,
            SubjectTeacher subjectTeacher,
            List<Classroom> classrooms
    ) {
        instance.setDateRequest(LocalDateTime.now());
        instance.setDateBooking(request.getDateBooking());
        instance.setStartTimeBooking(request.getStartTimeBooking());
        instance.setEndTimeBooking(request.getEndTimeBooking());
        instance.setDescription(instance.getDescription());
        instance.setStatus(BookingStatus.WAIT);
        instance.setSubjectTeacher(subjectTeacher);
        instance.setClassrooms(classrooms);
        return this;
    }
}
