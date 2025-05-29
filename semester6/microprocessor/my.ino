#include <Arduino.h>

// intialize the LED pins and buzzer pin
int ledPins[] = {7, 8, 9, 10};
const int buzzerPin = 6;
const int trigerPin = 3;
const int echoPin = 4;

long duration;
int distance;

void setup()
{
    for (int i = 0; i < 4; i++)
    {
        pinMode(ledPins[i], OUTPUT);
    }

    pinMode(buzzerPin, OUTPUT);
    pinMode(trigerPin, OUTPUT);
    pinMode(echoPin, INPUT);
}

void loop()
{
    digitalWire(trigerPin, LOW);
    delayMicroseconds(2);
    digitalWrite(trigerPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigerPin, LOW);

    duration = pulseIN(echoPin, HIGH);
    distance = duration * 0.034 / 2;

    int ledsToLight = 0;

    if (distance <= 40 && distance > 30)
    {
        ledsToLight = 1;
    }
    else if (distance <= 30 && distance > 20)
    {
        ledsToLight = 2;
    }
    else if (distance <= 20 && distance > 10)
    {
        ledsToLight = 3;
    }
    else if (distance <= 10 && distance > 0)
    {
        ledsToLight = 4;
    }
    else
    {
        ledsToLight = 0;
    }

    for (int i = 0; i < 4; i++)
    {
        if (i < ledsToLight)
        {
            digitalWrite(ledPins[i], HIGH);
        }
        else
        {
            digitalWrite(ledPins[i], LOW);
        }
    }

    if (ledsToLight > 0)
    {
        digitalWrite(buzzerPin, HIGH);
        delay(1000); // Buzzer will sound for 1 second
        digitalWrite(buzzerPin, LOW);
        delay(400)
    }
    else
    {
        digitalWrite(buzzerPin, LOW);
        delay(100); // Wait for 100 milliseconds before the next measurement
    }
}
