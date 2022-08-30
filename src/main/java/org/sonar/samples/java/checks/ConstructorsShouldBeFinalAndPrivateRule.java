package org.sonar.samples.java.checks;

import java.util.Collections;
import java.util.List;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = "ConstructorsShouldBeFinalAndPrivateRule")
public class ConstructorsShouldBeFinalAndPrivateRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return Collections.singletonList(Tree.Kind.CONSTRUCTOR);
  }

  @Override
  public void visitNode(Tree tree) {

    MethodTree methodTree = (MethodTree) tree;
    if (methodTree.is(Tree.Kind.CONSTRUCTOR) && !methodTree.symbol().isPrivate()) {
      reportIssue(methodTree, "Constructors should be private");
    }
  }
}
