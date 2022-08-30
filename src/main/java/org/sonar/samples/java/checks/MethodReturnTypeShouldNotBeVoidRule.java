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

@Rule(key = "MethodReturnTypeShouldNotBeVoidRule")
public class MethodReturnTypeShouldNotBeVoidRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Kind> nodesToVisit() {
    return Collections.singletonList(Kind.METHOD);
  }

  @Override
  public void visitNode(Tree tree) {
    MethodTree method = (MethodTree) tree;

    if (Objects.requireNonNull(method.returnType()).symbolType().isVoid()) {
      reportIssue(method.simpleName(), "Methods should not have the returntype 'void'");
    }
  }

}
