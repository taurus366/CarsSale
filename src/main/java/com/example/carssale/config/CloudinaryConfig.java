package com.example.carssale.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Set the Cloud name associated with the cloudinary account.
 * @param cloudName  the Cloud name associated with the cloudinary account.
 * @return
 */
@Configuration
@ConfigurationProperties(prefix = "cloudinary")
public class CloudinaryConfig {

    private String cloudName;
    private String apiKey;
    private String apiSecret;

    public String getCloudName() {
        return cloudName;
    }

    public CloudinaryConfig setCloudName(String cloudName) {
        this.cloudName = cloudName;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public CloudinaryConfig setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public CloudinaryConfig setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }
}
