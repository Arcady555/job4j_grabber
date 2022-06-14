package ru.job4j.ood.srp;

import java.util.List;

public interface UserDoing {
    public User createUser(String name);

    int userAmount(List<User> list);
}
