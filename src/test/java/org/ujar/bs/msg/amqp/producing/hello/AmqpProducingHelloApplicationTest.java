package org.ujar.bs.msg.amqp.producing.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmqpProducingHelloApplicationTest {

  @Test
  void contextLoad() {
    Assertions.assertDoesNotThrow(this::doNotThrowException);
  }

  private void doNotThrowException() {
    // This method will never throw exception
  }
}
