package com.shijiwei.shoppingmall.trade.controller;

import com.shijiwei.shoppingmall.trade.dao.entity.Commodity;
import com.shijiwei.shoppingmall.trade.dao.entity.Response;
import com.shijiwei.shoppingmall.trade.dao.vo.CommodityVo;
import com.shijiwei.shoppingmall.trade.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api("商品相关的接口")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @GetMapping("/getCommodityList")
    @ApiOperation("获取商品列表")
    @ResponseBody
    public Response<List<CommodityVo>> getCommodityList() {
        List<Commodity> commodityList = commodityService.getCommodityList();
        List<CommodityVo> commodityVoList = new ArrayList<>();
        for (int i = 0; i < commodityList.size(); i++) {
            CommodityVo vo = new CommodityVo();
            BeanUtils.copyProperties(commodityList.get(i), vo);
            commodityVoList.add(vo);
        }
        return Response.buildSuccessResponse(commodityVoList);
    }

}
