package com.jonmax;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jonmax.domain.Orders;
import com.jonmax.domain.User;
import com.jonmax.mapper.OrderMapper;
import com.jonmax.mapper.UserMapper;
import com.jonmax.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@SpringBootTest
public class JonMaxTestApp {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("JonMax2");
        user.setPassword("1234");
        user.setName("jm2");
        user.setAge(19);
        int insert = userMapper.insert(user);
        Long id = user.getId();
        System.out.println(insert + "=====" + id);
    }

    @Test
    public void testDelete() {
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        int i = userMapper.deleteBatchIds(ids);
        System.out.println(i);
    }

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(8);
        System.out.println(i);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "提姆");
        map.put("age", 22);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserName("JonMax0");
        user.setName("jm0");
        user.setId(5L);
        userMapper.updateById(user);
    }

    @Test
    public void testWrapper() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name", "j");
        wrapper.gt("age", 18);
        userMapper.selectList(wrapper);
    }

    @Test
    public void testWrapper1() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.like("name", "j");
        wrapper.gt("age", 18);
        userMapper.selectList(wrapper);
    }

    @Test
    public void testWrapper02() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1, 2, 3);
        wrapper.between("age", 12, 29);
        wrapper.like("address", "山");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void testWrapper03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", 1, 2, 3);
        queryWrapper.gt("age", 10);
        queryWrapper.orderByAsc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testSelect01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "user_name", "age");
        queryWrapper.orderByAsc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testSelect02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "user_name".equals(tableFieldInfo.getColumn());
            }
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testSelect03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(new User());
        queryWrapper.select(new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return !"address".equals(tableFieldInfo.getColumn());
            }
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testSelect03P() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(new User());
        queryWrapper.select(tableFieldInfo -> !"address".equals(tableFieldInfo.getColumn())
        );
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.gt("id", "1");
        updateWrapper.set("age", 99);
        userMapper.update(null, updateWrapper);
    }

    @Test
    public void testUpdateLamadaWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getAge, 18);
        queryWrapper.eq(User::getAddressStr, "狐山");
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void testMyself() {
        User myUser = userMapper.findMyUser(5L);
        System.out.println(myUser);
    }

    @Test
    public void testMyselfWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getId, 5L);
        queryWrapper.like(User::getUserName, "J");
        List<User> users = userMapper.findMyUserWrapper(queryWrapper);
    }

    @Test
    public void testPage() {

        IPage<User> Page = new Page<>();
        Page.setSize(2);
        Page.setCurrent(2);
        //  IPage<User> Page1 = userMapper.selectPage(iPage, null);
        userMapper.selectPage(Page, null);
        System.out.println(Page.getTotal());
        System.out.println(Page.getPages());
        System.out.println(Page.getCurrent());
    }

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testOrderAll() {
        orderMapper.findAllOrders();
    }

    @Test
    public void testOrderQueryPage() {
        Page<Orders> page = new Page<>();
        page.setSize(2);
        page.setCurrent(2);
        orderMapper.findAllOrders(page);
    }

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        List<User> userList = userService.getBaseMapper()
                .selectList(null).
                stream().filter(user -> !user.getId().equals(1L)).collect(Collectors.toList());
        System.out.println(userList);
    }

    @Test
    public void testUserService2() {
        List<User> userList = userService.list().
                stream().filter(user -> user.getId().equals(1L)).collect(Collectors.toList());
        System.out.println(userList);
    }
}
