package com.ifood.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MapUriBuilder {

    public String build(String url, String parametro, String city, String APIkey) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(parametro, city)
                .queryParam("apikey", APIkey).build(false).toUriString();

    }

    public String build(String url, String APIkey) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apikey", APIkey).build(false).toUriString();

    }
}
