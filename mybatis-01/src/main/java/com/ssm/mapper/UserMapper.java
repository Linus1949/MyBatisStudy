package com.ssm.mapper;

import com.ssm.pojo.User;

import java.util.List;
import java.util.Map;

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
     * 使用Map调用ID查询
     */
    User getUserById2(Map<String,Object> map);

    /**
     * 添加新用户
     * @param user
     */
    void addUser(User user);

    /**
     * 利用Map直接填充
     */
    void addUser2(Map<String,Object> map);

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

    /**
     * 对用户名使用模糊搜索，获取一组用户
     * @param name
     */
    List<User> searchUserByName(String name);
}
