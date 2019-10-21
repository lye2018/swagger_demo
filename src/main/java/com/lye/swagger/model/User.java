package com.lye.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户实体类")
public class User {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户性别")
    private Integer sex = 0;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(String userName, Integer sex) {
        this.userName = userName;
        this.sex = sex;
    }

    public User() {
        super();
    }
}
