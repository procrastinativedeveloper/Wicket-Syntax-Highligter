package com.procrastination.utils;

/**
 * Helper method, here you can find some helper static method - I don't wanna add dependecy to commons or Guava when I need only few method
 */
public class Toolbox {

    /**
     * Helper class
     */
    private Toolbox() {
        throw new RuntimeException("Cannot create instance of helper class");
    }


    public static boolean emptyOrNull(String toTest) {
        return toTest == null || toTest.length() == 0;
    }

    public static boolean isNotEmptyOrNull(String toTest) {
        return !emptyOrNull(toTest);
    }

    public static void argumentNotNull(Object object, String message) {
        if (null == object) {
            throw new IllegalArgumentException(message);
        }
    }

}
