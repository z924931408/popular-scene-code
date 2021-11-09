package com.zhu.fte.biz.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String userName;
    private int age;
}
