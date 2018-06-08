package com.axmor.dao;

import com.axmor.issue.Issue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class IssueDao {
//    private final List<Issue> issues = ImmutableList.of(
//            new Issue("task1","dorzhi","created"),
//            new Issue("task2","dorzhi","created"),
//            new Issue("task3","dorzhi","created"),
//            new Issue("task4","dorzhi","created")
//    );
    private SessionFactory sessionFactory = buildSessionFactory(Issue.class);

    private Session session = sessionFactory.openSession();

    public Issue getAllIssues() {
        Issue issue = session.get(Issue.class, 1);
        return issue;
    }
    private static SessionFactory buildSessionFactory(Class clazz) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }
}
