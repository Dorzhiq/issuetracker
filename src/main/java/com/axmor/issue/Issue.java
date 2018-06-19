package com.axmor.issue;

import javax.persistence.*;
import java.util.List;

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

    @ElementCollection(targetClass = Comment.class)
    @CollectionTable(name = "comment", joinColumns = @JoinColumn(name = "author"))
    @Column
    private Set<Comment> comments = new HashSet<>();

    public Issue(){}
    public Issue(String name, String author, String description, String status, Set<Comment> comments) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.status = status;
        this.comments = comments;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }
}
