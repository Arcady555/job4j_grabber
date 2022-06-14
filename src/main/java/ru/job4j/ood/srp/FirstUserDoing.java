package ru.job4j.ood.srp;

import java.util.List;

public class FirstUserDoing implements UserDoing {
    private List<User> list = List.of(createUser("A"),
            createUser("B"),
            createUser("C")
    );

    @Override
    public User createUser(String name) {
        return new User(name);
    }

    @Override
    public int userAmount(List<User> list) {
        return list.size();
    }

    public void print() {
        for (User user : list) {
            System.out.println("name='" + user.getName());
        }
    }
}
