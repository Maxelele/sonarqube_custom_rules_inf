package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.ModifierTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.Collections;
import java.util.List;

@Rule(key = "VariablesShouldBeFinalRule")
public class VariablesShouldBeFinalRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Kind> nodesToVisit() {
    return Collections.singletonList(Kind.VARIABLE);
  }

  @Override
  public void visitNode(Tree tree) {
    VariableTree variable = (VariableTree) tree;

    Symbol symbol = variable.symbol();

    if (!symbol.isFinal()) {
      reportIssue(variable.simpleName(), "Variables should be final");
    }

  }

}
