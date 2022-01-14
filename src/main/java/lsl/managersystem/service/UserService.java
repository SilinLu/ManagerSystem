package lsl.managersystem.service;

import lsl.managersystem.domain.User;

import java.util.List;

public interface UserService {
    List<User> query();
    User queryid(String id);
    int insertUser(User User);
    int updateUser(User User);
    int deleteUser(User User);
}