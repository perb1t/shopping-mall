package com.shijiwei.shoppingmall.trade.service;

import com.shijiwei.shoppingmall.trade.dao.entity.Commodity;
import com.shijiwei.shoppingmall.trade.dao.vo.CommodityVo;

import java.util.List;

public interface CommodityService {

    List<Commodity> getCommodityList();
}
