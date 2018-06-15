package com.axmor.dao;

import com.axmor.issue.Comment;
import com.axmor.issue.Issue;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.axmor.Main.issueDao;
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
        Issue result = session.get(Issue.class, id);
        session.close();
        return result;
    }
    public void patchIssue(String id, String author, String status) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = session.get(Issue.class, id);
        issue.setAuthor(author);
        issue.setStatus(status);
        session.update(issue);
        session.getTransaction().commit();
        session.close();
    }
    public void postIssue(String name, String author, String description, String status, List<Comment> comments) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = new Issue(name, author, description, status, comments);
        session.save(issue);
        session.getTransaction().commit();
        session.close();
    }
    public void postComment(long id, String author, String status, String text) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = session.get(Issue.class, id);
        List<Comment> comments = issue.getComments();
        Comment comment = new Comment(status, author, text);
        comments.add(comment);
        issue.setComments(comments);
        session.save(comment);
        session.update(issue);
        session.getTransaction().commit();
        session.close();
    }
    public List<Comment> getCommentsById(long id) {
        Session session = sessionFactory.openSession();
        Issue issue = session.get(Issue.class, id);
        List<Comment> result = issue.getComments();
        session.close();
        return result;
    }
//    public void deleteIssue(String id) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Issue issue = session.get(Issue.class, id);
//        session.delete(issue);
//        session.getTransaction().commit();
//        session.close();
//    }

}
