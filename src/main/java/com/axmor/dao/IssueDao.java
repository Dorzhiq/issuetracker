package com.axmor.dao;

import com.axmor.issue.Issue;
import com.google.common.collect.ImmutableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static com.axmor.Main.issueDao;
import static com.axmor.Main.sessionFactory;

public class IssueDao {
//    private final List<Issue> issues = ImmutableList.of(
//            new Issue("task1","dorzhi","created"),
//            new Issue("task2","dorzhi","created"),
//            new Issue("task3","dorzhi","created"),
//            new Issue("task4","dorzhi","created")
//    );
    public List<Issue> getAllIssues() {
        Session session = sessionFactory.openSession();
        List<Issue> result = (List<Issue>) session.createQuery("from Issue").list();
        session.close();
        return result;
    }
    public Issue getById(String id) {
        Session session = sessionFactory.openSession();
        Issue result = session.get(Issue.class, id);
        //List<Issue> result = (List<Issue>) session.createQuery("from Issue where Issue.issueId = id").list();
        session.close();
        return result;
    }
    //тут пут
//    public void patchIssue(String id) {
//        Session session = sessionFactory.openSession();
//        Issue issue = session.load(Issue.class, id);
//        session.beginTransaction();
//        session.update(issue);
//        session.getTransaction().commit();
//        session.close();
//    }
}
