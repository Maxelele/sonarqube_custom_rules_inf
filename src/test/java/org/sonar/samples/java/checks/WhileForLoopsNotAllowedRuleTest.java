package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class WhileForLoopsNotAllowedRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/WhileForLoopsNotAllowedRule.java")
      .withCheck(new WhileForLoopsNotAllowedRule())
      .verifyIssues();
  }

}
