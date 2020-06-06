package org.khu.testsuite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.khu.HelloWorld;

public class HelloWorldTestSuite {

   @Test public void testOutput() {
      assertThat(HelloWorld.sayIt()).isEqualTo("Hi, world!");
   }
}
