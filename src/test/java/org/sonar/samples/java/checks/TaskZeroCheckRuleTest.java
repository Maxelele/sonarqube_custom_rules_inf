package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class TaskZeroCheckRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/TaskZeroCheckRule.java")
      .withCheck(new TaskZeroCheckRule())
      .verifyIssues();
  }

}
