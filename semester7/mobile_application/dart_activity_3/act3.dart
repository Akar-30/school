// Mixins
mixin Walker {
  void walk() => print('It can walk.');
}

mixin Flyer {
  void fly() => print('It can fly.');
}

mixin Swimmer {
  void swim() => print('It can swim.');
}

mixin Hunter {
  void hunt() => print('It can hunt.');
}

// Base class
class Animal {
  String name;
  Animal(this.name);
}

// Subclasses
class Dog extends Animal with Walker, Hunter {
  Dog(String name) : super(name);
}

class Bird extends Animal with Flyer, Walker {
  Bird(String name) : super(name);
}

class Fish extends Animal with Swimmer {
  Fish(String name) : super(name);
}

void main() {
  List<Animal> animals = [
    Dog('Alex'),
    Bird('Tuty'),
    Fish('Fishi'),
    Dog('Doggy'),
  ];

  // Display animals and abilities
  for (var animal in animals) {
    print('\n${animal.name}:');
    if (animal is Walker) (animal as Walker).walk();
    if (animal is Flyer) (animal as Flyer).fly();
    if (animal is Swimmer) (animal as Swimmer).swim();
    if (animal is Hunter) (animal as Hunter).hunt();
  }

  // Set for unique names
  Set<String> uniqueNames = animals.map((a) => a.name).toSet();
  print('\nUnique names: $uniqueNames');

  // Map for habitats
  Map<String, String> habitats = {
    'Alex': 'House',
    'Tuty': 'Sky',
    'Fishi': 'Ocean',
    'Doggy': 'House',
  };
  print('Habitats: $habitats');

  // Group by ability
  print('\nFlyers: ${animals.whereType<Bird>().map((a) => a.name).toList()}');
  print(
    'Walkers: ${animals.where((a) => a is Walker).map((a) => a.name).toList()}',
  );
  print('Swimmers: ${animals.whereType<Fish>().map((a) => a.name).toList()}');
  print(
    'Hunters: ${animals.where((a) => a is Hunter).map((a) => a.name).toList()}',
  );
}
