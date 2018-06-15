package com.example.group12.courseregisteration;

public class DateTime {

    private String date;
    private String start;
    private String end;

    public DateTime(String date, String start, String end){
        this.date=date;
        this.start=start;
        this.end=end;
    }

    //get method
    public String getDate(){
        return date;
    }
    public String getStartTime(){
        return start;
    }
    public String getEndTime(){
        return end;
    }

    //set method
    public void setDate(String date){
        this.date=date;
    }
    public void setStartTime(String start){
        this.start=start;
    }
    public void setEndTime(String end){
        this.end=end;
    }

}
