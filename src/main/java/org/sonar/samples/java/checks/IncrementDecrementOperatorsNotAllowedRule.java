package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.TypeTree;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Rule(key = "IncrementDecrementOperatorsNotAllowedRule")
public class IncrementDecrementOperatorsNotAllowedRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Kind> nodesToVisit() {
    return List.of(Kind.POSTFIX_INCREMENT, Kind.PREFIX_INCREMENT,
      Kind.POSTFIX_DECREMENT, Kind.PREFIX_DECREMENT,
      Kind.PLUS_ASSIGNMENT, Kind.MINUS_ASSIGNMENT);
  }

  @Override
  public void visitNode(Tree tree) {
    reportIssue(tree, "'++, --, +=, -=' Statements are not allowed");
  }

}
