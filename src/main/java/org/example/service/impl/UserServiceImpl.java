package org.example.service.impl;

import org.example.dto.request.UpdateUserRequest;
import org.example.dto.response.ApiResponse;
import org.example.dto.response.PageResponse;
import org.example.entity.Image;
import org.example.entity.User;
import org.example.exception.StatusCode;
import org.example.repository.ImageRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    private final CloudinaryClient cloudinaryClient;

    @Autowired
    private ImageRepository imageRepository;

//    @Autowired
//    public UserServiceImpl(CloudinaryClient cloudinaryClient) {
//        this.cloudinaryClient = cloudinaryClient;
//    }

    @Override
    public ApiResponse<Object> getUserList(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return ApiResponse.builder()
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .data(new PageResponse<>(userPage.getContent(), userPage.getTotalPages(), userPage.getTotalElements()))
                .build();
    }
    @Override
    public ApiResponse<Object> getUserDetail(Integer userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        return ApiResponse.builder()
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .data(user)
                .build();
    }

    @Override
    public ApiResponse<Object> updateUserDetail(Integer userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found!"));
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
//        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return ApiResponse.builder()
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .data(user)
                .build();
    }
    @Override
    public ApiResponse<Object> deactivateUser(Integer userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found!"));
//        user.setActive(!user.isActive());
//        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return ApiResponse.builder()
                .data(user)
                .build();
    }

//    @Override
//    public ApiResponse<Object> uploadUserAvatar(String userId, MultipartFile file) {
//        try{
//            String fileName = file.getOriginalFilename();
////            String filePath = cloudinaryClient.uploadMultipartFile(file, fileName);
//            Image image = new Image();
//            image.setImageName(fileName);
//            image.setImagePath(filePath);
//            image.setUpdatedAt(LocalDateTime.now());
//            image.setIsActive(1L);
//            image.setObjectId(userId);
//            image.setSource("user-service");
//            image.setCreatedAt(LocalDateTime.now());
//            imageRepository.save(image);
//        }  catch (RuntimeException e){
//            return ApiResponse.builder()
//                    .code(StatusCode.UNCATEGORIZED_EXCEPTION.getCode())
//                    .message(StatusCode.UNCATEGORIZED_EXCEPTION.getMessage())
//                    .build();
//        }
//        return ApiResponse.builder()
//                .code(StatusCode.SUCCESS.getCode())
//                .message(StatusCode.SUCCESS.getMessage())
//                .build();
//    }

//    @Override
//    public ApiResponse<Object> getUserAvatar(String userId) {
//        String imagePath = imageRepository.findImagePathByUserId(userId);
//        if (imagePath == null) {
//            return ApiResponse.builder()
//                    .code(StatusCode.DATA_EXISTED.getCode())
//                    .message(StatusCode.DATA_EXISTED.getMessage())
//                    .build();
//        }
//        return ApiResponse.builder()
//                .code(StatusCode.SUCCESS.getCode())
//                .message(StatusCode.SUCCESS.getMessage())
//                .data(imagePath)
//                .build();
//    }

}
