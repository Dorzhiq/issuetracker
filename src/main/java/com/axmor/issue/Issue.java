package com.axmor.issue;

import javax.persistence.*;

@Entity
@Table
public class Issue {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String issueId;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String description;

    @Column
    private String status;

//    @Column
//    private List<My_Comment> comments;

    public Issue(){}
    public Issue(String name, String author, String description, String status) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.status = status;
    }

    public String getIssueId() { return issueId; }

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

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
