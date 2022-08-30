class MyClass {

  private MyClass(MyClass mc) { }

  MyClass(MyClass mc) { } // Noncompliant

  int test() {

  }

  private int test2() {

  }

}
