package com.axmor.dao;

import com.axmor.issue.Issue;
import com.google.common.collect.*;
import java.util.List;

public class IssueDao {
    private final List<Issue> issues = ImmutableList.of(
            new Issue("task1","dorzhi","created"),
            new Issue("task2","dorzhi","created"),
            new Issue("task3","dorzhi","created"),
            new Issue("task4","dorzhi","created")
    );
    public Iterable<Issue> getAllIssues() {
        return issues;
    }
}
