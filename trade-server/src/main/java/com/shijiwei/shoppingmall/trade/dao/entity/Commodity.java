package com.shijiwei.shoppingmall.trade.dao.entity;

import lombok.Data;

@Data
public class Commodity {

    private Long commodityId;

    private String name;

    private String photoUrl;

    private float price;

}
