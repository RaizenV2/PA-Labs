package com.company;

public class TestClass {
    private  Integer intreg;
    private String nume;

    public TestClass(Integer intreg, String nume) {
        this.intreg = intreg;
        this.nume = nume;
    }

    public Integer getIntreg() {
        return intreg;
    }

    public String getNume() {
        return nume;
    }

    public void showSomething()
    {
        System.out.println("Show Something");
    }
}
