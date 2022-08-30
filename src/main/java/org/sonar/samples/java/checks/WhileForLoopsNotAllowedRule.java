package org.sonar.samples.java.checks;

import java.util.Collections;
import java.util.List;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;

@Rule(key = "WhileForLoopsNotAllowedRule")
public class WhileForLoopsNotAllowedRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return List.of(Tree.Kind.WHILE_STATEMENT, Tree.Kind.FOR_STATEMENT);
    //return Collections.singletonList(Tree.Kind.BLOCK);
  }

  @Override
  public void visitNode(Tree tree) {

      if (tree.is(Tree.Kind.WHILE_STATEMENT)) {
        reportIssue(tree, "While Statements are not allowed");
      } else if (tree.is(Tree.Kind.FOR_STATEMENT)) {
        reportIssue(tree, "For Statements are not allowed");
      }

    /*for (Tree item : ((BlockTree) tree).body()) {
      if (item.is(Tree.Kind.WHILE_STATEMENT)) {
        reportIssue(item, "While Statements are not allowed");
      } else if (item.is(Tree.Kind.FOR_STATEMENT)) {
        reportIssue(tree, "For Statements are not allowed");
      }
    }*/
  }
}
