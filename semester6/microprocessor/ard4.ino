#include <Arduino.h>

int ledPin[] = {7, 8, 9, 10};
const int buzzerPin = 6;

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
    else if (distance <= 10)
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
            digitalWrite(ledPin[i], HIGH);
        }
        else
        {
            digitalWrite(ledPin[i], LOW);
        }
    }

    if (ledsToLight > 0)
    {
        digitalWrite(buzzerPin, HIGH);
        delay(100);
        digitalWrite(buzzerPin, LOW);

        int silenceDelay = 400 - (ledsToLight * 100);
        if (silenceDelay < 20)
            silenceDelay = 20;

        delay(silenceDelay);
    }
    else
    {
        digitalWrite(buzzerPin, LOW);
        delay(100);
    }
}