package org.lab2.lab2;

import jakarta.enterprise.context.Dependent;

@Dependent // Tells Weld to create a new instance when requested
public class V8Engine implements Engine {
    @Override
    public void start() {
        System.out.println("Engine roaring to life: VROOOM!");
    }
}
