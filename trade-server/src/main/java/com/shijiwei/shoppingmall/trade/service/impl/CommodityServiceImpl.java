package com.shijiwei.shoppingmall.trade.service.impl;

import com.shijiwei.shoppingmall.trade.dao.entity.Commodity;
import com.shijiwei.shoppingmall.trade.dao.vo.CommodityVo;
import com.shijiwei.shoppingmall.trade.mapper.CommodityMapper;
import com.shijiwei.shoppingmall.trade.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public List<Commodity> getCommodityList() {
        List<Commodity> commodities = commodityMapper.selectList(null);
        return commodities;
    }
}
