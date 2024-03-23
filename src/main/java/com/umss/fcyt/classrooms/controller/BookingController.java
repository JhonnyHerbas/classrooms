package com.umss.fcyt.classrooms.controller;

import com.umss.fcyt.classrooms.api.request.booking.CreateBookingRequest;
import com.umss.fcyt.classrooms.model.domain.Booking;
import com.umss.fcyt.classrooms.service.BookingService;
import com.umss.fcyt.classrooms.util.constants.ControllersConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ControllersConstants.Api.API + "/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping()
    public Booking createBooking(@RequestBody CreateBookingRequest createBookingRequest) {
        log.info("Execute create new Booking.");
        return bookingService.create(createBookingRequest);
    }
}
