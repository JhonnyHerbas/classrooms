package com.umss.fcyt.classrooms.api.request.booking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class CreateBookingRequest {
    private LocalDate dateBooking;
    private LocalTime startTimeBooking;
    private LocalTime endTimeBooking;
    private String description;
    private Integer idGroup;
    private List<Integer> classrooms;
}
