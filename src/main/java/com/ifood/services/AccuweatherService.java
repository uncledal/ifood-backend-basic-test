package com.ifood.services;

import com.ifood.services.accuweather.response.AccuweatherMapResponse;
import com.ifood.utils.MapUriBuilder;
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
public class AccuweatherService {

    private static final Logger logger = Logger.getLogger(AccuweatherService.class.getName());

    private RestTemplate restTemplate;

    private MapUriBuilder uriBuilder;

    @Value("${accuweather.url}")
    String url;

    @Value("${accuweather.APIkey}")
    String apikey;

    public AccuweatherService(@Autowired RestTemplate restTemplate, @Autowired MapUriBuilder uriBuilder) {
        this.restTemplate = restTemplate;
        this.uriBuilder = uriBuilder;
    }

    @Cacheable(value = "city", key = "#city")
    public AccuweatherMapResponse getWeatherByCity(String city) throws RestClientException {
        AccuweatherMapResponse accuweatherMapResponse;
        logger.info("information for city: " + city.toLowerCase());
        //TODO pora falta de tempo não perdi tempo com a API do Accuweather
        String uri = uriBuilder.build(url+"1?", apikey);
        accuweatherMapResponse = restTemplate.getForObject(uri, AccuweatherMapResponse.class);
        return accuweatherMapResponse;
    }

    @CacheEvict(allEntries = true, cacheResolver = "city")
    @Scheduled(fixedDelayString = "${cachettl}")
    public void cacheEvict() {

    }
}
