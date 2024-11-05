package com.iqkv.incubator.quickstart.amqpproducinghello.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableConfigurationProperties({AmqpQueuesProperties.class})
class ApplicationConfig {
}
