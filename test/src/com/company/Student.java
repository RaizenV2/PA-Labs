package com.company;

public class Student implements Comparable<Student> {
    private int ID;
    private String name;
    private Double cgpa;

    @Override
    public int compareTo(Student student) {
        return 0;
    }

    public Student(int id , String name, Double cgpa)
    {
        this.ID = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID()
    {
        return this.ID;
    }
    public String getName()
    {
        return this.name;
    }
    public Double getCGPA()
    {
        return this.cgpa;
    }
}
