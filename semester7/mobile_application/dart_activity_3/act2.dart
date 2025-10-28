class Car {
  static const String manufacturer = 'Mercedes-Benz';
  static int carCounter = 0;
  final String model;
  final int year;

  Car(this.model, this.year) {
    carCounter++;
  } // Regular constructor has effect on the static counter because
  // it creates new instances at runtime.

  // Constant constructor cannot affect the counter because it creates
  // compile-time constant instances.
  const Car.constant(this.model, this.year);

  void displayInfo() {
    print('$manufacturer $model ($year)');
  }
}

void main() {
  var car1 = Car('S-Class', 2022);
  var car2 = Car('G-Class', 2023);
  const car3 = Car.constant('Mayabch', 2024);

  car1.displayInfo();
  car2.displayInfo();
  car3.displayInfo();

  print('Total cars created: ${Car.carCounter}');

  // Uncommenting below will cause error:
  // car1.model = 'Yaris'; // Error: final variable cannot be modified
}
