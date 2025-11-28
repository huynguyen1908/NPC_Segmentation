package org.example.controller;


import org.example.dto.request.UpdateUserRequest;
import org.example.dto.response.ApiResponse;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}/exists")
    public ResponseEntity<Boolean> checkUserExists(@PathVariable Integer userId) {
        return ResponseEntity.ok(userRepository.existsById(userId));
    }

    @GetMapping("/get-list")
    public ApiResponse<Object> getUserList(Pageable pageable) {
        return userService.getUserList(pageable);
    }

    @GetMapping("/user-detail/{userId}")
    public ApiResponse<Object> getUserDetail(@PathVariable Integer userId) {
        return userService.getUserDetail(userId);
    }

    @PutMapping("/update/{userId}")
    public ApiResponse<Object> updateUserDetail(@PathVariable Integer userId, @RequestBody UpdateUserRequest request){
        return userService.updateUserDetail(userId, request);
    }

    @PutMapping("/deactivate/{userId}")
    public ApiResponse<Object> deactivateUser(@PathVariable Integer userId){
        return userService.deactivateUser(userId);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

//    @PostMapping("/upload-avatar/{userId}")
//    public ApiResponse<Object> uploadUserAvatar(@PathVariable String userId, @RequestParam MultipartFile files) {
//        return userService.uploadUserAvatar(userId, files);
//    }
//
//    @GetMapping("/avatar/{userId}")
//    public ApiResponse<Object> getUserAvatar(@PathVariable String userId) {
//        return userService.getUserAvatar(userId);
//    }

    @GetMapping("/get-username/{userId}")
    public String getUsernameByUserId(@PathVariable("userId") Integer userId) {
        return userRepository.getUsernameByUserId(userId);
    }
}
