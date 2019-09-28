package com.fehead.model;

public class DeliveryPointModel {

    private Integer id;
    private String deliveryPoint;
    private String area;

    public DeliveryPointModel(Integer id, String deliveryPoint, String area) {
        this.id = id;
        this.deliveryPoint = deliveryPoint;
        this.area = area;
    }

    public DeliveryPointModel() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
