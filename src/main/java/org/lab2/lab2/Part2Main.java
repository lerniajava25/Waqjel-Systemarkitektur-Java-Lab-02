package org.lab2.lab2;

import java.lang.reflect.Constructor;

class MiniDIContainer {
    public <T> T getInstance(Class<T> clazz) {
        try {
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length == 0) {
                return clazz.getDeclaredConstructor().newInstance();
            }

            Constructor<?> constructor = constructors[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameterInstances = new Object[parameterTypes.length];


            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> paramType = parameterTypes[i];

                if (paramType.equals(Engine.class)) {
                    parameterInstances[i] = getInstance(V8Engine.class);
                } else if (paramType.equals(Car.class)) {
                    parameterInstances[i] = getInstance(SedanCar.class);
                } else {
                    parameterInstances[i] = getInstance(paramType);
                }
            }

            return clazz.cast(constructor.newInstance(parameterInstances));
        } catch (Exception e) {
            throw new RuntimeException("DI container failed to resolve dependencies for: " + clazz.getName(), e);
        }
    }
}

public class Part2Main {
    public static void main(String[] args) {
        System.out.println("=== Part 2: Custom DI Container ===");
        MiniDIContainer container = new MiniDIContainer();

        SedanCar autoCar = container.getInstance(SedanCar.class);
        autoCar.drive();
    }
}
