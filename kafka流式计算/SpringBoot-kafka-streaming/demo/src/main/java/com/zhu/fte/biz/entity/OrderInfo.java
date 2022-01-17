package com.zhu.fte.biz.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author zjq
 * @date 2022/1/15 23:57
 */
@Data
public class OrderInfo implements Serializable {

    private Long id;

    private String userId;

    private String orderNo;

    private Long orderTime;

    private BigDecimal orderAmt;

}
