package org.example.service;


import org.example.dto.request.UpdateUserRequest;
import org.example.dto.response.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    ApiResponse<Object> getUserList(Pageable pageable);
    ApiResponse<Object> getUserDetail(Integer userId);
    ApiResponse<Object> updateUserDetail(Integer userId, UpdateUserRequest request);
    ApiResponse<Object> deactivateUser(Integer userId);
//    ApiResponse<Object> uploadUserAvatar(String userId, MultipartFile files);
//    ApiResponse<Object> getUserAvatar(String userId);
}
