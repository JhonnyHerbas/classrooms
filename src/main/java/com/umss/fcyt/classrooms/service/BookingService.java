package com.umss.fcyt.classrooms.service;

import com.umss.fcyt.classrooms.api.request.booking.CreateBookingRequest;
import com.umss.fcyt.classrooms.model.builder.BookingCreateBuilder;
import com.umss.fcyt.classrooms.model.domain.Booking;
import com.umss.fcyt.classrooms.model.domain.Classroom;
import com.umss.fcyt.classrooms.model.domain.SubjectTeacher;
import com.umss.fcyt.classrooms.model.repository.BookingRepository;
import com.umss.fcyt.classrooms.model.repository.ClassroomRepository;
import com.umss.fcyt.classrooms.model.repository.SubjectTeacherRepository;
import com.umss.fcyt.classrooms.util.constants.BookingStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final SubjectTeacherRepository subjectTeacherRepository;
    private final ClassroomRepository classroomRepository;

    public BookingService(
            BookingRepository bookingRepository,
            SubjectTeacherRepository subjectTeacherRepository,
            ClassroomRepository classroomRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.subjectTeacherRepository = subjectTeacherRepository;
        this.classroomRepository = classroomRepository;
    }

    @Transactional
    public Booking create(CreateBookingRequest createBookingRequest) {
        Optional<SubjectTeacher> group = subjectTeacherRepository.findById(createBookingRequest.getIdGroup());
        List<Classroom> classrooms = classroomRepository.findByIdIn(createBookingRequest.getClassrooms());
        if (group.isPresent()) {
            Booking newBooking = BookingCreateBuilder.getInstance(createBookingRequest, group.get(), classrooms).build();
            Booking saved = bookingRepository.save(newBooking);
            classrooms.forEach(classroom -> classroom.getBookings().add(saved));
            return saved;
        } else {
            throw new RuntimeException("Not found group the subject.");
        }
    }

    public List<Booking> getAllBookings(BookingStatus bookingStatus) {
        return bookingRepository.findAllByStatusOrderByDateRequestAsc(bookingStatus);
    }
}
