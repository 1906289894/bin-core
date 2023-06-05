package com.core.tools.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
class DTO{
    private String product;

    //物资备案总条数
    private Integer materialRecordTotalNum;

    //用steam分组统计即可
    //TODO materialRecordTotalNum = productList 所有 materialRecordNum 和

    //物资备案总金额
    private String materialRecordTotalAmount;
    //完成数  完成金额

    //设备备案总条数
    private Integer equipmentRecordTotalNum;
    //物资备案总金额
    private String equipmentRecordTotalAmount;
    //完成数  完成金额

    //其他 工程  服务    合计。。。。。

    private List<Product> productList;


    @Getter
    @Setter
    static class Product{
        //物资备案条数
        private Integer materialRecordNum;
        //物资备案金额
        private String materialRecordAmount;
        //完成数  完成金额

        //设备备案条数
        private Integer equipmentRecordNum;
        //物资备案金额
        private String equipmentRecordAmount;
        //完成数  完成金额

        //其他 工程  服务    合计。。。。。
    }
}