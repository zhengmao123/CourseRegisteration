package com.example.group12.courseregisteration;

public class DateTimeConflict {

    private Boolean result;

    public DateTimeConflict(){

    }

    //return true if has date time conflict
    public Boolean TimeConflict(DateTime a, DateTime b){

        double as = Double.parseDouble(a.getStartTime().toString());
        double ae = Double.parseDouble(a.getEndTime().toString());
        double bs = Double.parseDouble(b.getStartTime().toString());
        double be = Double.parseDouble(b.getEndTime().toString());

        if(a.getDate().equals(b.getDate())) {

            if (as > be || bs > ae) {
                result = false;
                return false;

            } else {
                result = true;
                return true;
            }
        }
        else{
            result = false;
            return false;
        }

    }

    //return 1 if datetime has conflict
    public int TestResult(){

        if(result == true){
            return 1;
        }
        else{
            return 0;
        }

    }



}
