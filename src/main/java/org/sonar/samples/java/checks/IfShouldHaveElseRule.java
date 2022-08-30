package org.sonar.samples.java.checks;

import java.util.Collections;
import java.util.List;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.IfStatementTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = "IfShouldHaveElseRule")
public class IfShouldHaveElseRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return Collections.singletonList(Tree.Kind.IF_STATEMENT);
  }

  @Override
  public void visitNode(Tree tree) {
    IfStatementTree treeIfStmt = (IfStatementTree) tree;
    if (treeIfStmt.elseStatement() == null) {
      reportIssue(treeIfStmt.ifKeyword(), "\"if ...\" constructs should end with \"else\" clauses.");
      }
    }
}
