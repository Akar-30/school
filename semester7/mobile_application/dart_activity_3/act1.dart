import 'dart:io';

// The three main functions for temperature conversion
double celsiusToFahrenheit(double celsius) {
  return (celsius * 9 / 5) + 32;
}

double fahrenheitToCelsius(double fahrenheit) {
  return (fahrenheit - 32) * 5 / 9;
}

double celsiusToKelvin(double celsius) {
  return celsius + 273.15;
}

// User input to read the temperature value and the conversion type

void main() {
  while (true) {
    print('\nSelect a conversion type in below:');
    print('1. Celsius to Fahrenheit');
    print('2. Fahrenheit to Celsius');
    print('3. Celsius to Kelvin');
    print('0. to quit');

    String? input = stdin.readLineSync();

    // Validate choice input
    int? choice = int.tryParse(input ?? '');
    if (choice == null || choice < 0 || choice > 3) {
      print('Invalid choice! Please enter 1, 2, 3, or 0.');
      continue;
    }

    double result;

    switch (choice) {
      case 1:
        print('Enter the temperature value: (In Celsius)');
        double? tempValue = _getValidTemperature();
        if (tempValue == null) continue;
        result = celsiusToFahrenheit(tempValue);
        print(
          '${tempValue.toStringAsFixed(2)} °C is equal to ${result.toStringAsFixed(2)} °F',
        );
        break;
      case 2:
        print('Enter the temperature value: (In Fahrenheit)');
        double? tempValue = _getValidTemperature();
        if (tempValue == null) continue;
        result = fahrenheitToCelsius(tempValue);
        print(
          '${tempValue.toStringAsFixed(2)} °F is equal to ${result.toStringAsFixed(2)} °C',
        );
        break;
      case 3:
        print('Enter the temperature value: (In Celsius)');
        double? tempValue = _getValidTemperature();
        if (tempValue == null) continue;
        result = celsiusToKelvin(tempValue);
        print(
          '${tempValue.toStringAsFixed(2)} °C is equal to ${result.toStringAsFixed(2)} K',
        );
        break;
      case 0:
        print('Exiting the program. Goodbye!');
        return;
    }
  }
}

// Helper function to get valid temperature input
double? _getValidTemperature() {
  String? input = stdin.readLineSync();
  double? temp = double.tryParse(input ?? '');
  if (temp == null) {
    print('Invalid temperature! Please enter a valid number.');
    return null;
  }
  return temp;
}
