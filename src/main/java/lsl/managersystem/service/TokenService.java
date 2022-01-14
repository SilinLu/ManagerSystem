package lsl.managersystem.service;

import lsl.managersystem.domain.User;

public interface TokenService {
    String getToken(User user);
}
