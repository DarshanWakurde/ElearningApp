package com.example.elearningapp;

public class pdfmodel {
    String id;
    String Title,Discription,Link;
    public pdfmodel(String id, String title, String discription, String link) {
        this.id = id;
        Title = title;
        Discription = discription;
        Link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
