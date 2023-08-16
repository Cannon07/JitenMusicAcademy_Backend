# Jiten's Music Academy API Documentation

This document provides an overview of the API endpoints available in this application.

## Student Service Endpoints

`POST api/students`
Creates a new student.

`GET api/students/{studentId}`
Retrieves a student by ID.

`GET api/students`
Retrieves a list of all students.

`PUT api/students/{studentId}`
Updates student information.

`DELETE api/students/{studentId}`
Deletes a student by ID.

`GET api/students/{studentId}/classes`
Retrieves classes in which a student is enrolled.

## Instructor Service Endpoints

`POST api/instructors`
Creates a new instructor.

`GET api/instructors/{instructorId}`
Retrieves an instructor by ID.

`GET api/instructors`
Retrieves a list of all instructors.

`PUT api/instructors/{instructorId}`
Updates instructor information.

`DELETE api/instructors/{instructorId}`
Deletes an instructor by ID.

`GET api/instructors/{instructorId}/classes`
Retrieves classes taught by an instructor.

## Class Service Endpoints

`POST api/classes`
Creates a new class.

`GET api/classes/{classId}`
Retrieves a class by ID.

`GET api/classes`
Retrieves a list of all classes.

`PUT api/classes/{classId}`
Updates class information.

`DELETE api/classes/{classId}`
Deletes a class by ID.

`POST api/classes/{classId}/enroll/{studentId}`
Enrolls a student in a class.

`POST api/classes/{classId}/assign-instructor/{instructorId}`
Assigns an instructor to a class.

`GET api/classes/{classId}/students`
Retrieves students enrolled in a class.

`GET api/classes/{classId}/instructor`
Retrieves the instructor of a class.
