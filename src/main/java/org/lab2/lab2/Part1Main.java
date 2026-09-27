package org.lab2.lab2;

public class Part1Main {
    public static void main(String[] args) {
        System.out.println("=== Part 1: Manual Constructor Injection ===");

        Engine engine = new V8Engine();

        Car car = new SedanCar(engine);

        car.drive();
    }
}
