package com.demo.provider.service.controller;

import com.demo.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/7 4:17 AM
 */
@RestController
public class ServiceInstanceRestController {
    
    @RequestMapping("/user")
    public ResponseEntity<UserDTO> getUserInfo() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setName("危常焕");
        userDTO.setSex(1);
        userDTO.setFlag(true);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
}
