package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class ConstructorsShouldBeFinalAndPrivateRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/ConstructorsShouldBeFinalAndPrivateRule.java")
      .withCheck(new ConstructorsShouldBeFinalAndPrivateRule())
      .verifyIssues();
  }

}
