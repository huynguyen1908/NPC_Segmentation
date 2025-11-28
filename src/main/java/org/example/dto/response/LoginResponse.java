package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entity.User;

@Data
@AllArgsConstructor
public class LoginResponse {
    String accessToken;
    User user;
}
