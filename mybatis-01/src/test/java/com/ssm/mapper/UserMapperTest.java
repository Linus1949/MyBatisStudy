package com.ssm.mapper;

import com.ssm.pojo.User;
import com.ssm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        // 第一步获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 执行Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        //
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        //关闭session
        sqlSession.close();
    }

    @Test
    public void testGetUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",2);
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2.toString());
        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        User user = new User(5, "EEE", "EEE");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(user);
        sqlSession.commit();
        User userById = mapper.getUserById(user.getId());
        System.out.println(userById);
    }

    @Test
    public void testAddUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",5);
        map.put("userName","EEE");
        map.put("userPwd","eee");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1,"AAA","aaa"));
        sqlSession.commit();
        System.out.println(mapper.getUserById(1));
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(5);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSearchUserByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> b = mapper.searchUserByName("B");
        b.forEach(System.out::println);
        sqlSession.commit();
        sqlSession.close();
    }
}
