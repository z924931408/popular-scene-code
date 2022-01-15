package com.zhu.fte.biz.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户对象")
@TableName("user_info")
public class UserInfo {
    @ApiModelProperty(value = "用户ID", name = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @ApiModelProperty(value = "用户姓名", name = "userName")
    private String userName;
    @ApiModelProperty(value = "用户年龄", name = "age")
    private int age;
}
