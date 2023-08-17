package com.example.demo;

import java.util.List;

public class HelloRequest {

    private String mis;
    private String name;
    private List<String> subjectList;

    public String getMis() {
        return mis;
    }

    public void setMis(String mis) {
        this.mis = mis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "HelloRequest{" +
                "mis='" + mis + '\'' +
                ", name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
