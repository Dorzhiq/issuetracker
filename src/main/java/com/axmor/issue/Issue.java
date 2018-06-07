package com.axmor.issue;

public class Issue {
    private String name;
    private String author;
    private String status;

    public Issue(){}
    public Issue(String name, String author, String status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
