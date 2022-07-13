package org.ujar.basics.amqp.producing.hello.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ujar.basics.amqp.producing.hello.consumer.GreetingMessageConsumer;

@Configuration
@RequiredArgsConstructor
public class AmqpConsumingTestConfig {
  private final AmqpQueuesProperties queues;

  @Bean
  public SimpleMessageListenerContainer importCountriesListenerContainer(
      final ConnectionFactory connectionFactory, final MessageListenerAdapter importCountriesListenerAdapter) {
    final var container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queues.getGreeterQueue());
    container.setMessageListener(importCountriesListenerAdapter);
    container.setAcknowledgeMode(AcknowledgeMode.AUTO);
    container.setDefaultRequeueRejected(false);
    return container;
  }

  @Bean
  public MessageListenerAdapter importCountriesListenerAdapter(final GreetingMessageConsumer consumer) {
    return new MessageListenerAdapter(consumer, "consume");
  }
}
