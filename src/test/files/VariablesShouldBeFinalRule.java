class MyClass {

  MyClass(final MyClass mc) { }

  final int test = 0;

  int test2 = 0; // Noncompliant

  final String string = "final";

  String s = "not final"; // Noncompliant

}
