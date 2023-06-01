package com.datvutech.javabasic2.bai06;

public class Employee {
    private String id;
    private String fullName;
    private String joinedDate;
    private String birthday;
    private String department;

    public Employee(String id, String fullName, String joinedDate, String birthday, String department) {
        this.id = id;
        this.fullName = fullName;
        this.joinedDate = joinedDate;
        this.birthday = birthday;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return fullName;
    }
}