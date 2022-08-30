class MyClass {

  MyClass(final MyClass mc) { }

  final int test = 0;

  void test2() { // Noncompliant

  }

  void test3(int i) { // Noncompliant

  }

  int test4(int i) {

  }

}
