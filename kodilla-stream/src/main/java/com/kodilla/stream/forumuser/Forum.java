package com.kodilla.stream.forumuser;

import java.util.*;

public class Forum {
    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum(){
        usersList.add(new ForumUser(1, "Adi1", 'M', 1990,11, 1, 15));
        usersList.add(new ForumUser(2, "#$TR", 'M', 1993,12, 21, 0));
        usersList.add(new ForumUser(3, "Srfe", 'M', 1995,5, 28, 45));
        usersList.add(new ForumUser(4, "GEWSR", 'F', 2000,2, 10, 7));
        usersList.add(new ForumUser(5, "EWF", 'M', 1986,8, 2, 0));
        usersList.add(new ForumUser(6, "#WRr", 'F', 1967,8, 31, 115));
    }

    public List<ForumUser> getUsersList(){
        return new ArrayList<>(usersList);
    }
}
