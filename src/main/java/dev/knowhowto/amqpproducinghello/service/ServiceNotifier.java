package dev.knowhowto.amqpproducinghello.service;

import dev.knowhowto.amqpproducinghello.model.Greeting;
import dev.knowhowto.amqpproducinghello.producer.GreetingMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceNotifier {

  private final GreetingMessageProducer messageProducer;

  @Scheduled(fixedDelay = 10000)
  public void scheduledCall() {
    messageProducer.send(new Greeting("Hello, World!"));
  }
}
