package com.demo.caller.service.servicefacade;

import com.demo.caller.service.failback.UserFailBackService;
import com.demo.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/7 4:26 AM
 */
@FeignClient(name="PROVIDER-DEMO",fallback = UserFailBackService.class)
public interface IUserService {

    @RequestMapping(value = "/api/v1/user",method = RequestMethod.GET)
    UserDTO getUserInfo();
}
