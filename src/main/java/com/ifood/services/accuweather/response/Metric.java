package com.ifood.services.accuweather.response;

public class Metric {

    private double Value;
    private String Unit;
    private Integer UnitType;

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Integer getUnitType() {
        return UnitType;
    }

    public void setUnitType(Integer unitType) {
        UnitType = unitType;
    }
}
