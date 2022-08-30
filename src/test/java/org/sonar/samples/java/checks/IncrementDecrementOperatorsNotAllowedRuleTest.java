package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class IncrementDecrementOperatorsNotAllowedRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/IncrementDecrementOperatorsNotAllowedRule.java")
      .withCheck(new IncrementDecrementOperatorsNotAllowedRule())
      .verifyIssues();
  }

}
