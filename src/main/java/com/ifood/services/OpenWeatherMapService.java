package com.ifood.services;

import com.ifood.utils.MapUriBuilder;
import com.ifood.services.openweather.response.OpenWeatherMapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class OpenWeatherMapService {

    private static final Logger logger = Logger.getLogger(OpenWeatherMapService.class.getName());

    private RestTemplate restTemplate;

    private MapUriBuilder uriBuilder;

    @Value("${openweathermap.url}")
    String url;

    @Value("${openweathermap.APIkey}")
    String APIkey;

    public OpenWeatherMapService(@Autowired RestTemplate restTemplate, @Autowired MapUriBuilder uriBuilder) {
        this.restTemplate = restTemplate;
        this.uriBuilder = uriBuilder;
    }

    @Cacheable(value = "city", key = "#city")
    public OpenWeatherMapResponse getWeatherByCity(String city) throws RestClientException {
        OpenWeatherMapResponse openWeatherMapResponse;
        logger.info("information for city: " + city.toLowerCase());
        String uri = uriBuilder.build(url, "q", city, APIkey);
        openWeatherMapResponse = restTemplate.getForObject(uri, OpenWeatherMapResponse.class);
        return openWeatherMapResponse;
    }

    @CacheEvict(allEntries = true, cacheResolver = "city")
    @Scheduled(fixedDelayString = "${cachettl}")
    public void cacheEvict() {

    }
}
