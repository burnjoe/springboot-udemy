package com.mojo.springboot.learn_spring_boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * application.properties:
 * currency-service.url=
 * currency-service.username=
 * currency-service.key=
 * [prefix].[attribute]  -->  currency-service.url
 */

// It will map any properties starting with currency-service from application.properties
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

    // This can be populated through externalized configuration properties
    private String url;
    private String username;
    private String key;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
