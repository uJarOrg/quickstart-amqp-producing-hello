package com.iqkv.incubator.quickstart.amqpproducinghello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class AmqpProducingHelloApplication {
  static {
    System.setProperty("spring.amqp.deserialization.trust.all", "true");
  }

  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(AmqpProducingHelloApplication.class);
    springApplication.setApplicationStartup(new BufferingApplicationStartup(2048));
    springApplication.run(args);
  }
}
