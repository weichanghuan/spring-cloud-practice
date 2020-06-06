package com.demo.caller.service.controller;

import com.demo.caller.service.servicefacade.UserService;
import com.demo.dto.ApiResponse;
import com.demo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/7 2:17 AM
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ResponseEntity<ApiResponse<UserDTO>> getUserInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.okay(userService.getUserInfo()));
    }

}
