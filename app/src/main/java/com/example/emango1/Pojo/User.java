package com.example.emango1.Pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private Integer id;
    @SerializedName("careerDetail")
    private CareerDetails careerDetail;
    @SerializedName("topCollegeList")
    private List<TopCollege> topCollegeList = null;
    @SerializedName("topExamsList")
    private List<TopExams> topExamsList = null;
    @SerializedName("title")
    private String title;
    @SerializedName("careerImage")
    private String careerImage;
    @SerializedName("videoUrl")
    private Object videoUrl;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("utimestamp")
    private String utimestamp;
    @SerializedName("track")
    private String track;
    @SerializedName("utrack")
    private String utrack;
    @SerializedName("status")
    private String status;
    @SerializedName("career")
    private Integer career;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CareerDetails getCareerDetail() {
        return careerDetail;
    }

    public void setCareerDetail(CareerDetails careerDetail) {
        this.careerDetail = careerDetail;
    }

    public List<TopCollege> getTopCollegeList() {
        return topCollegeList;
    }

    public void setTopCollegeList(List<TopCollege> topCollegeList) {
        this.topCollegeList = topCollegeList;
    }

    public List<TopExams> getTopExamsList() {
        return topExamsList;
    }

    public void setTopExamsList(List<TopExams> topExamsList) {
        this.topExamsList = topExamsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCareerImage() {
        return careerImage;
    }

    public void setCareerImage(String careerImage) {
        this.careerImage = careerImage;
    }

    public Object getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(Object videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUtimestamp() {
        return utimestamp;
    }

    public void setUtimestamp(String utimestamp) {
        this.utimestamp = utimestamp;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getUtrack() {
        return utrack;
    }

    public void setUtrack(String utrack) {
        this.utrack = utrack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

}
