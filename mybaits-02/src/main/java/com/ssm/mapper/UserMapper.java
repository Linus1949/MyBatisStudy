package com.ssm.mapper;

import com.ssm.pojo.User;

import java.util.List;

/**
 * @author Linus
 */
public interface UserMapper {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 通过ID获取用户
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 添加新用户
     * @param user
     */
    void addUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过ID删除用户
     * @param id
     */
    void deleteUserById(int id);
}
