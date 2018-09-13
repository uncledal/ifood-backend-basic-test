package com.ifood.rest;

import com.ifood.services.AccuweatherService;
import com.ifood.services.OpenWeatherMapService;
import com.ifood.services.accuweather.response.AccuweatherMapResponse;
import com.ifood.services.openweather.response.OpenWeatherMapResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OpenWeatherMapRest {
    private OpenWeatherMapService openWeatherMapService;

    private AccuweatherService accuweatherService;

    public OpenWeatherMapRest(
            @Autowired OpenWeatherMapService openWeatherMapService,
            @Autowired AccuweatherService accuweatherService) {
        this.openWeatherMapService = openWeatherMapService;
        this.accuweatherService = accuweatherService;
    }

    @GetMapping("/getweather")
    @HystrixCommand(fallbackMethod = "fallbackgetWeatherByCity")
    public OpenWeatherMapResponse getWeatherByCity(@RequestParam("city") String city) {
        return openWeatherMapService.getWeatherByCity(city);
    }

    public AccuweatherMapResponse fallbackgetWeatherByCity(@RequestParam("city") String city) {
        return accuweatherService.getWeatherByCity(city);
    }

}
