package com.example.project.event;

public class ContentClass {
    String title;
    String content;
    String detail;
    String mainImageView;
    String link;

    public void setTitle(String title){
        this.title=title;
    }
    public void setContent(String content){
        this.content=content;
    }
    public void setDetail(String detail){
        this.detail=detail;
    }
    public void setMainImageView(String mainImageView){
        this.mainImageView=mainImageView;
    }
    public void setlink(String link){
        this.link=link;
    }

    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
    public String getDetail(){
        return this.detail;
    }
    public String getMainImageView(){
        return this.mainImageView;
    }
    public String getLink(){
        return this.link;
    }
}
