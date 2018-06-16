package com.example.group12.courseregisteration;

public class Course {

    private String course_name, course_date, time_start, time_end, location, professor;

    public Course(String course_name, String course_date, String time_start, String time_end, String location, String professor){

        this.course_name = course_name;
        this.course_date = course_date;
        this.time_start = time_start;
        this.time_end = time_end;
        this.location = location;
        this.professor = professor;

    }
    public String getCourseName(){
        return course_name;
    }
    public String getCourseDate(){
        return course_date;
    }
    public String getTimeStart(){
        return time_start;
    }
    public String getTimeEnd(){
        return time_end;
    }
    public String getCourseLocation(){
        return location;
    }
    public String getCourseProfessor(){
        return professor;
    }



}
