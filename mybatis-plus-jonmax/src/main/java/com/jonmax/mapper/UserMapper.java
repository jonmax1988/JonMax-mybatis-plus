package com.jonmax.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jonmax.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//@Mapper
public interface UserMapper extends BaseMapper<User> {

     User findMyUser(@Param("userId") Long userId);

     List<User> findMyUserWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
