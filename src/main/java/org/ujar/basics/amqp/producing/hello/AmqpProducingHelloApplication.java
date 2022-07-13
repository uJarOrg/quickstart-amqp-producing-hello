package org.ujar.basics.amqp.producing.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmqpProducingHelloApplication {
  public static void main(String[] args) {
    SpringApplication.run(AmqpProducingHelloApplication.class, args);
  }
}
