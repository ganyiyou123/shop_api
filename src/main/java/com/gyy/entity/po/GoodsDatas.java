package com.gyy.entity.po;

public class GoodsDatas {
    private  Integer id;
    private Integer goodsId;
    private String dataDatas;// {"1":3,"2":9}
    private Integer storcks;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getDataDatas() {
        return dataDatas;
    }

    public void setDataDatas(String dataDatas) {
        this.dataDatas = dataDatas;
    }

    public Integer getStorcks() {
        return storcks;
    }

    public void setStorcks(Integer storcks) {
        this.storcks = storcks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
