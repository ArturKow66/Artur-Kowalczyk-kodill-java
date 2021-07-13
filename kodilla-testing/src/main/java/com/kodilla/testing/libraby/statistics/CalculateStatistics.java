package com.kodilla.testing.libraby.statistics;

import java.util.*;

public class CalculateStatistics {

    private final Statistics statistics;

    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Map<String, Double> calculateAdvStatistics(Statistics statistics) {

        Map<String, Double> statisticsMap = new HashMap<>();

        final String stringNumberOfUsers = "Number of users: ";

        List<String> usersList = statistics.usersNames();
        double numberOfUsers = usersList.size();
        statisticsMap.put(stringNumberOfUsers, numberOfUsers);

        final String stringNumberOfPosts = "Number of posts: ";

        double numberOfPosts = statistics.postsCount();
        statisticsMap.put(stringNumberOfPosts, numberOfPosts);

        final String stringNumberOfComments = "Number of comments: ";

        double numberOfComments = statistics.commentsCount();
        statisticsMap.put(stringNumberOfComments, numberOfComments);

        final String stringAveragePostsPerUser = "Average number of posts per user: ";

        if (numberOfUsers == 0) {
            statisticsMap.put("Number of users: ", numberOfUsers);
        } else {
            double averagePostsPerUser = numberOfPosts / numberOfUsers;
            statisticsMap.put(stringAveragePostsPerUser, averagePostsPerUser);
        }

        final String stringAverageCommentsPerUser = "Average number of comments per user: ";

        if (numberOfUsers == 0) {
            statisticsMap.put("Number of users: ", numberOfUsers);
        } else {
            double averageCommentsPerUser = numberOfComments / numberOfUsers;
            statisticsMap.put(stringAverageCommentsPerUser, averageCommentsPerUser);
        }

        final String stringAverageCommentsPerPost = "Average number of comments per post: ";

        if (numberOfPosts == 0) {
            statisticsMap.put("Number of posts: ", numberOfPosts);
        } else {
            double averageCommentsPerPost = numberOfComments / numberOfPosts;
            statisticsMap.put(stringAverageCommentsPerPost, averageCommentsPerPost);
        }
        return statisticsMap;
    }

    public String showStatistics() {
        return calculateAdvStatistics(statistics).toString();
    }
}
