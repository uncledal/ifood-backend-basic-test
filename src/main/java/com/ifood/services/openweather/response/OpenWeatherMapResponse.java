package com.ifood.services.openweather.response;

import java.util.List;

public class OpenWeatherMapResponse {

    private List<Weather> weather;
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
