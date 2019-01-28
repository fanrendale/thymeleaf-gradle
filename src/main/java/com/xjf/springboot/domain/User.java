package com.xjf.springboot.domain;

import lombok.Data;

/**
 * @author xjf
 * @date 2019/1/28 11:57
 */
@Data
public class User {
    private Long id;        //实体的唯一标识

    private String name;

    private String email;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
