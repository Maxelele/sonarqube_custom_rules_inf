package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import java.util.*;

@Rule(key = "TaskZeroCheckRule")
public class TaskZeroCheckRule extends IssuableSubscriptionVisitor {

  private List<String> expected_methods = new LinkedList<>(Arrays.asList("fact", "binom", "ggT", "fib"));
  private List<String> expected_facttest = new LinkedList<>(Arrays.asList("example_fact", "data_fact"));
  private List<String> expected_binomtest = new LinkedList<>(Arrays.asList("example_binom", "data_binom"));
  private List<String> expected_ggttest = new LinkedList<>(Arrays.asList("example_ggT", "data_ggT"));
  private List<String> expected_fibtest = new LinkedList<>(Arrays.asList("example_fib", "data_fib"));

  @Override
  public List<Kind> nodesToVisit() {
    return Collections.singletonList(Kind.CLASS);
  }

  @Override
  public void visitNode(Tree tree) {
    if (((ClassTree) tree).simpleName().name().equals("Methods")) {
      for (Tree member : ((ClassTree) tree).members()) {
        if (member.is(Tree.Kind.METHOD)) {
          expected_methods.remove(((MethodTree) member).simpleName().name());
        }
      }
      if (!expected_methods.isEmpty()) {
       // addIssueOnFile("The methods: " + String.join(", ", expected_methods) + "are missing");
        reportIssue(tree, "The methods: " + String.join(", ", expected_methods) + " are missing");
        System.out.println("The methods: " + String.join(", ", expected_methods) + " are missing");
      }
    }
    else if (((ClassTree) tree).simpleName().name().equals("FactTest")) {
      for (Tree member : ((ClassTree) tree).members()) {
        if (member.is(Tree.Kind.METHOD)) {
          expected_facttest.remove(((MethodTree) member).simpleName().name());
        }
      }
      if (!expected_facttest.isEmpty()) {
        reportIssue(tree,"The methods: " + String.join(", ", expected_facttest) + " are missing");
      }
    }
    else if (((ClassTree) tree).simpleName().name().equals("BinomTest")) {
      for (Tree member : ((ClassTree) tree).members()) {
        if (member.is(Tree.Kind.METHOD)) {
          expected_binomtest.remove(((MethodTree) member).simpleName().name());
        }
      }
      if (!expected_binomtest.isEmpty()) {
        reportIssue(tree,"The methods: " + String.join(", ", expected_binomtest) + " are missing");
      }
    }
    else if (((ClassTree) tree).simpleName().name().equals("GgtTest")) {
      for (Tree member : ((ClassTree) tree).members()) {
        if (member.is(Tree.Kind.METHOD)) {
          expected_ggttest.remove(((MethodTree) member).simpleName().name());
        }
      }
      if (!expected_ggttest.isEmpty()) {
        reportIssue(tree,"The methods: " + String.join(", ", expected_ggttest) + " are missing");
      }
    }
    else if (((ClassTree) tree).simpleName().name().equals("FibTest")) {
      for (Tree member : ((ClassTree) tree).members()) {
        if (member.is(Tree.Kind.METHOD)) {
          expected_fibtest.remove(((MethodTree) member).simpleName().name());
        }
      }
      if (!expected_fibtest.isEmpty()) {
        reportIssue(tree,"The methods: " + String.join(", ", expected_fibtest) + " are missing");
      }
    }
  }
}
