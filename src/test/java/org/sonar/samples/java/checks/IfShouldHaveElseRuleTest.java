package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class IfShouldHaveElseRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/IfShouldHaveElseRule.java")
      .withCheck(new IfShouldHaveElseRule())
      .verifyIssues();
  }

}
