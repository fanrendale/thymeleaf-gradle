package com.xjf.springboot.repository;

import com.xjf.springboot.domain.User;

import java.util.List;

/**
 * @author xjf
 * @date 2019/1/28 13:34
 */
public interface UserRespository {
    /**
     * 保存或者更新User
     * @param user
     * @return
     */
    User saveOrUpdteUser(User user);

    /**
     * 根据id删除User
     * @param id
     */
    void deleteUserById(Long id);

    /**
     * 根据id查询User
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取全部的User
     * @return
     */
    List<User> getUserList();
}
