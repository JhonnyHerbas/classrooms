package com.umss.fcyt.classrooms.util.constants;

public final class DatabaseConstants {

    public static final class TeacherDB {
        public static final String TEACHER = "teacher";

        public static final class Id {
            public static final String ID = "teacher_id";
        }

        public static final class Name {
            public static final String NAME = "teacher_name";
            public static final int LENGTH = 50;
        }

        public static final class LastName {
            public static final String LAST_NAME = "teacher_last_name";
            public static final int LENGTH = 80;
        }

        public static final class Email {
            public static final String EMAIL = "teacher_email";
            public static final int LENGTH = 80;
        }

        public static final class Username {
            public static final String USERNAME = "teacher_username";
            public static final int LENGTH = 80;
        }

        public static final class Password {
            public static final String PASSWORD = "teacher_password";
        }

        public static final class ProfilePicture {
            public static final String PROFILE = "teacher_profile_picture";
        }
    }

    public static final class SubjectDB {
        public static final String SUBJECT = "subject";

        public static final class Id {
            public static final String ID = "subject_id";
        }

        public static final class NameSubject {
            public static final String NAME = "subject_name";
            public static final int LENGTH = 80;
        }

        public static final class Semester {
            public static final String SEMESTER = "subject_semester";
        }
    }

    public static final class PhotoClassroomDB {
        public static final String PHOTO_CLASSROOM = "photo_classroom";

        public static final class Id {
            public static final String ID = "photo_id";
        }

        public static final class Image {
            public static final String FILE = "photo_file";
        }
    }

    public static final class ClassroomDB {
        public static final String CLASSROOM = "classroom";

        public static final class Id {
            public static final String ID = "classroom_id";
        }

        public static final class ClassroomNumber {
            public static final String NUMBER = "classroom_number";
            public static final int LENGTH = 8;

        }

        public static final class Description {
            public static final String DESCRIPTION = "classroom_description";
        }

        public static final class Capacity {
            public static final String CAPACITY = "classroom_capacity";
        }

        public static final class Building {
            public static final String BUILDING = "location_building";
            public static final int LENGTH = 100;
        }

        public static final class Level {
            public static final String LEVEL = "location_level";
        }

        public static final class UrlGoogleMaps {
            public static final String URL = "location_url";
        }
    }

    public static final class SubjectTeacherDB {
        public static final String SUBJECT_TEACHER = "subject_teacher";

        public static final class Id {
            public static final String ID = "subject_teacher_id";
        }

        public static final class Group {
            public static final String GROUP = "group_subject";
            public static final int LENGTH = 5;
        }
    }

    public static final class BookingDB {
        public static final String BOOKING = "booking";

        public static final class Id {
            public static final String ID = "booking_id";
        }

        public static final class DateTimeRequest {
            public static final String DATE_TIME_REQUEST = "booking_date_time_request";
        }

        public static final class DateBooking {
            public static final String DATE_BOOKING = "booking_date";
        }

        public static final class StartTimeBooking {
            public static final String START_TIME_BOOKING = "booking_start_time";
        }

        public static final class EndTimeBooking {
            public static final String END_TIME_BOOKING = "booking_end_time";
        }

        public static final class Description {
            public static final String DESCRIPTION = "booking_description";
        }

        public static final class NumberStudents {
            public static final String NUMBER_STUDENTS = "booking_number_students";
        }

        public static final class Status {
            public static final String STATUS = "booking_status";
            public static final int LENGTH = 15;
        }

        public static final class DescriptionResponse {
            public static final String DESCRIPTION_RESPONSE = "booking_description_response";
        }
    }
}
