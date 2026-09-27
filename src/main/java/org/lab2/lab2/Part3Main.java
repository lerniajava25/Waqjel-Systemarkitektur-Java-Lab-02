package org.lab2.lab2;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Part3Main {
    public static void main(String[] args) {
        System.out.println("=== Part 3: Weld CDI Container ===");

        // Initializes and starts up the local Weld standalone environment using the beans.xml
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            // Ask Weld to fetch the high-level interface.
            // It automatically finds SedanCar, detects it needs an Engine, installs V8Engine, and boots.
            Car cdiCar = container.select(Car.class).get();
            cdiCar.drive();
        }
    }
}
