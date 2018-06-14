package com.axmor.issue;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @Column(name = "author")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String author;

    @Column
    private String status;

    @Column
    private String text;

    public Comment(){}

    public Comment(String status, String author, String text){
        this.author = author;
        this.status = status;
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
