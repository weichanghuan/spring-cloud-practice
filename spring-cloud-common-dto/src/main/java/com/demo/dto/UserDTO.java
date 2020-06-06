package com.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/7 1:56 AM
 */
@Setter
@Getter
@ToString
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 3119256131810118612L;
    private String id;
    private Integer sex;
    private String name;
    private Boolean flag;
}
