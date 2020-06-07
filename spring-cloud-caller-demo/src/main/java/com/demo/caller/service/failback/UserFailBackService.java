package com.demo.caller.service.failback;

import com.demo.caller.service.servicefacade.IUserService;
import com.demo.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/7 11:57 PM
 */
@Component
public class UserFailBackService implements IUserService {

    @Override
    public UserDTO getUserInfo() {
        return failback();
    }

    private UserDTO failback(){
        UserDTO userDTO=new UserDTO();
        userDTO.setId("failback");
        return userDTO;
    }
}
