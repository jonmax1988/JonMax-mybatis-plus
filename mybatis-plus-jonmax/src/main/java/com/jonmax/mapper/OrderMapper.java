package com.jonmax.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jonmax.domain.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper extends BaseMapper<Orders> {

    List<Orders> findAllOrders();

    IPage<Orders> findAllOrders(Page<Orders> page);
}
