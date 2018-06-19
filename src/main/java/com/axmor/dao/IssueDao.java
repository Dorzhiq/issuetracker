package com.axmor.dao;

import com.axmor.issue.Comment;
import com.axmor.issue.Issue;
import org.hibernate.Session;

import java.util.List;

import static com.axmor.Main.sessionFactory;

public class IssueDao {

    public List<Issue> getAllIssues() {
        Session session = sessionFactory.openSession();
        List<Issue> result = (List<Issue>) session.createQuery("from Issue").list();
        session.close();
        return result;
    }
    public Issue getById(String id) {
        Session session = sessionFactory.openSession();
        return session.get(Issue.class, id);

    }
    public void patchIssue(String id, String author, String status) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = session.get(Issue.class, id);
        issue.setAuthor(author);
        issue.setStatus(status);
        session.getTransaction().commit();
    }
    public void postIssue(String name, String author, String description, String status, List<Comment> comments) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = new Issue(name, author, description, status, comments);
        session.save(issue);
        session.getTransaction().commit();
    }
    public void postComment(long id, String author, String status, String text) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = session.load(Issue.class, id);
        Comment comment = new Comment(status, author, text);
        issue.getComments().add(comment);
        session.flush();
        session.getTransaction().commit();
    }
    public List<Comment> getCommentsById(long id) {
        Session session = sessionFactory.openSession();
        return session.load(Issue.class, id).getComments();
    }

    public void deleteIssue(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = new Issue();
        issue.setIssueId(id);
        session.delete(issue);
        session.getTransaction().commit();
    }
}
