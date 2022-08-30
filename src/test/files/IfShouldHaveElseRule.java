class MyClass {
  MyClass(MyClass mc) { }

  int foo3(int value) {

    if (2 == 1) { // Noncompliant
      return 1;
    }

    if (2 == 1) {
      return 2;
    } else {
      return 3;
    }

  }
}
