package com.ifood.services.accuweather.response;

import java.util.List;

public class AccuweatherMapResponse {

    private String EpochTime;
    private String WeatherText;
    private Integer WeatherIcon;
    private Boolean IsDayTime;



    public String getEpochTime() {
        return EpochTime;
    }

    public void setEpochTime(String epochTime) {
        EpochTime = epochTime;
    }

    public String getWeatherText() {
        return WeatherText;
    }

    public void setWeatherText(String weatherText) {
        WeatherText = weatherText;
    }

    public Integer getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(Integer weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public Boolean getDayTime() {
        return IsDayTime;
    }

    public void setDayTime(Boolean dayTime) {
        IsDayTime = dayTime;
    }


}
