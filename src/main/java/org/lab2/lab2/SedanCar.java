package org.lab2.lab2;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class SedanCar implements Car {
    private final Engine engine;

    // @Inject tells Weld to automatically resolve the Engine dependency here
    @Inject
    public SedanCar(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Car is driving smoothly.");
    }
}
