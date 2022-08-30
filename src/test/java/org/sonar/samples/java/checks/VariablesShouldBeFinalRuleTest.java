package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class VariablesShouldBeFinalRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/VariablesShouldBeFinalRule.java")
      .withCheck(new VariablesShouldBeFinalRule())
      .verifyIssues();
  }

}
