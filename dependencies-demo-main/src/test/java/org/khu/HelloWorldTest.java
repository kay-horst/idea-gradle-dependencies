package org.khu;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

   @Test
   public void testOutput() {
      assertThat(HelloWorld.sayIt()).isEqualTo("Hello world!");
   }
}
