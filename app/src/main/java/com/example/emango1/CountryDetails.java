package com.example.emango1;

import com.google.gson.annotations.SerializedName;

class CountryDetails {
    @SerializedName("name")
    private String name;
    @SerializedName("exam")
    private boolean exam;
    @SerializedName("college")
    private boolean college;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExam() {
        return exam;
    }

    public void setExam(Boolean exam) {
        this.exam = exam;
    }

    public Boolean getCollege() {
        return college;
    }

    public void setCollege(Boolean college) {
        this.college = college;
    }
}
