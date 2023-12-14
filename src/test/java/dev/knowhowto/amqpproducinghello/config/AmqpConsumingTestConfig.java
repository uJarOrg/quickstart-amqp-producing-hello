package dev.knowhowto.amqpproducinghello.config;

import dev.knowhowto.amqpproducinghello.consumer.GreetingMessageConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class AmqpConsumingTestConfig {
  private final AmqpQueuesProperties queues;

  @Bean
  SimpleMessageListenerContainer greeterMessageListenerContainer(
      final ConnectionFactory connectionFactory, final MessageListenerAdapter greeterMessageListenerAdapter) {
    final var container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queues.getGreeterQueue());
    container.setMessageListener(greeterMessageListenerAdapter);
    container.setAcknowledgeMode(AcknowledgeMode.AUTO);
    container.setDefaultRequeueRejected(false);
    return container;
  }

  @Bean
  MessageListenerAdapter greeterMessageListenerAdapter(final GreetingMessageConsumer consumer) {
    return new MessageListenerAdapter(consumer, "consume");
  }
}
