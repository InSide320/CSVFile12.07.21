package com.company;

import java.time.LocalDate;
import java.util.Locale;

public class Employee {
    private String name;
    private String date;
    private String work_hours;

//    public Employee(String name, String date, String work_hours) {
//        this.name = name;
//        this.date =date;
//        this.work_hours =work_hours;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setWork_hours(String work_hours) {
        this.work_hours = work_hours;
    }

    public String getWork_hours() {
        return work_hours;
    }
    public String toString(){
        return getName() + getDate() + getWork_hours();
    }
}