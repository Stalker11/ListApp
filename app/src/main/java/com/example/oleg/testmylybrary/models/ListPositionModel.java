package com.example.oleg.testmylybrary.models;

/**
 * Created by Oleg on 15.07.2017.
 */

public class ListPositionModel {
    private String photoCaption;
    private String photoTime;
    private String photoDescription;
    private String photoLocal;
    private String head;
    private String body;
    private String[] photoLinks;

    public String[] getPhotoLinks() {
        return photoLinks;
    }

    public void setPhotoLinks(String[] photoLinks) {
        this.photoLinks = photoLinks;
    }

    public String getPhotoCaption() {
        return photoCaption;
    }

    public void setPhotoCaption(String photoCaption) {
        this.photoCaption = photoCaption;
    }

    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getPhotoLocal() {
        return photoLocal;
    }

    public void setPhotoLocal(String photoLocal) {
        this.photoLocal = photoLocal;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
