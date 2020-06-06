package org.khu;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class HelloWorldTestSuite {

   @Test
   public void testOutput() {
      assertThat(HelloWorld.sayIt()).isEqualTo("Hi, world!");
   }
}
