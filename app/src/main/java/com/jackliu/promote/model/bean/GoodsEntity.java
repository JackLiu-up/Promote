package com.jackliu.promote.model.bean;

import java.io.Serializable;

public class GoodsEntity implements Serializable {
    public String imgPath;//图片地址
    public String GoodsName;

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public GoodsEntity(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "imgPath='" + imgPath + '\'' +
                ", GoodsName='" + GoodsName + '\'' +
                '}';
    }
}
