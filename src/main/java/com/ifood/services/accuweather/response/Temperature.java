package com.ifood.services.accuweather.response;

import java.util.List;

public class Temperature {

    List<Metric> metrics;

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }
}
