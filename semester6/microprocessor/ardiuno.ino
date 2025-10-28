#include <Arduino.h>

int ledPin[] = {7, 8, 9, 10};
const int buzzerPin = 11;

const int trigPin = 3;
const int echoPin = 4;

long duration;
int distance;

void setup()
{
    for (int i = 0; i < 4; i++)
    {
        pinMode(ledPin[i], OUTPUT);
    }
    pinMode(buzzerPin, OUTPUT);
    pinMode(trigPin, OUTPUT);
    pinMode(echoPin, INPUT);
}

void loop()
{

    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);
    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigPin, LOW);

    duration = pulseIn(echoPin, HIGH);
    distance = duration * 0.034 / 2;

    if (distance <= 40 && distance > 30)
    {
        digitalWrite(ledPin[2], HIGH);
        digitalWrite(ledPin[3], HIGH);
        digitalWrite(ledPin[0], LOW);
        digitalWrite(ledPin[1], LOW);
        digitalWrite(buzzerPin, HIGH);
        delay(600);
        digitalWrite(buzzerPin, LOW);
    }
    else if (distance <= 30 && distance > 20)
    {
        digitalWrite(ledPin[2], HIGH);
        digitalWrite(ledPin[3], HIGH);
        digitalWrite(ledPin[0], LOW);
        digitalWrite(ledPin[1], LOW);
        digitalWrite(buzzerPin, HIGH);
        delay(400);
        digitalWrite(buzzerPin, LOW);
    }
    else if (distance <= 20 && distance > 10)
    {
        digitalWrite(ledPin[0], HIGH);
        digitalWrite(ledPin[1], HIGH);
        digitalWrite(ledPin[2], LOW);
        digitalWrite(ledPin[3], LOW);
        digitalWrite(buzzerPin, HIGH);
        delay(250);
        digitalWrite(buzzerPin, LOW);
    }
    else if (distance <= 10)
    {
        digitalWrite(ledPin[0], HIGH);
        digitalWrite(ledPin[1], HIGH);
        digitalWrite(ledPin[2], LOW);
        digitalWrite(ledPin[3], LOW);
        digitalWrite(buzzerPin, HIGH);
        delay(100);
        digitalWrite(buzzerPin, LOW);
    }
    delay(200);
}