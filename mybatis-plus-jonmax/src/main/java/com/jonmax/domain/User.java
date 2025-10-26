package com.jonmax.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("user")
public class User {
    @TableId
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    @TableField("address")
    private String addressStr;
}
