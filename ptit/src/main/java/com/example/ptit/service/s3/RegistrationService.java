package com.example.ptit.service.s3;

import com.example.ptit.entity.Registration;

import java.util.List;

public interface RegistrationService {
    public void saveRegistration(Registration registration) throws Exception;

    public void deleteRegistration(Registration registration) throws Exception;

    // get all courses of student take part in by student code
    public List<String> findCoursesByStudentCode(String studentCode) throws Exception;

    // get all Students take part in courses by course code
    public List<String> findStudentByCourseCode(String courseCode) throws  Exception;

    // update grade for registration
    public void updateRegistration(Registration registration) throws Exception;

    // get registration by studentCode and courseCode
    public Registration findRegistrationByStudentCodeAndCourseCode(String studentCode, String courseCode) throws Exception;
}
