package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    List<User>list=List.of(
            new User(1311L, "Durgesh Tiwari", "9129351971"),
            new User(1312L, "Ankit Tiwari", "9473162664"),
            new User(1314L, "Ravi Tiwari", "8789057657")

    );
    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
