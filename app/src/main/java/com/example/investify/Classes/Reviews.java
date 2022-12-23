package com.example.investify.Classes;

public class Reviews {

    private String score, title, content;

    public Reviews(){

    }

    public Reviews(String score, String title, String content){
        this.score = score;
        this.title = title;
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
