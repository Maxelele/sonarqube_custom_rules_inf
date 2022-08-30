package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class MethodReturnTypeShouldNotBeVoidRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/MethodReturnTypeShouldNotBeVoidRule.java")
      .withCheck(new MethodReturnTypeShouldNotBeVoidRule())
      .verifyIssues();
  }

}
