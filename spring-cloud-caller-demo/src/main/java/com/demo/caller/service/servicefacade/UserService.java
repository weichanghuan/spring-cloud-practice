package com.demo.caller.service.servicefacade;

import com.demo.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/7 4:26 AM
 */
@FeignClient("PROVIDER-DEMO")
public interface UserService {

    @RequestMapping(value = "/api/v1/user",method = RequestMethod.GET)
    UserDTO getUserInfo();
}
