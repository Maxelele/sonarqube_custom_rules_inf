class MyClass {
  MyClass(MyClass mc) { }

  int foo3(int value) {

    value++; // Noncompliant

    value += 1; // Noncompliant

    value--; // Noncompliant

    value -= 1; // Noncompliant

    int i = 2;

    value = i;

  }
}
