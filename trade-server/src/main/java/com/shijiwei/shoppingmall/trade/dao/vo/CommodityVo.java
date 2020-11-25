package com.shijiwei.shoppingmall.trade.dao.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品信息")
public class CommodityVo {

    @ApiModelProperty("商品名")
    private String name;

    @ApiModelProperty("商品图片")
    private String photoUrl;

    @ApiModelProperty("商品价格")
    private float price;
}
