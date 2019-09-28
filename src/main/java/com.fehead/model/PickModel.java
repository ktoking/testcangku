package com.fehead.model;

public class PickModel {

    private Integer id;
    private String pickCode;
    private String pickName;
    private String tailNumber;

    public PickModel(Integer id, String pickCode, String pickName, String tailNumber) {
        this.id = id;
        this.pickCode = pickCode;
        this.pickName = pickName;
        this.tailNumber = tailNumber;
    }


    public PickModel() {
    }

    public String getPickCode() {

        return pickCode;
    }

    public void setPickCode(String pickCode) {
        this.pickCode = pickCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPickName() {
        return pickName;
    }

    public void setPickName(String pickName) {
        this.pickName = pickName;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }
}
