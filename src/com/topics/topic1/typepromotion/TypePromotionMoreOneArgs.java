package com.topics.topic1.typepromotion;

public class TypePromotionMoreOneArgs {
    // Overloaded methods
    // Method that accepts integer and double
    public static void method(int i, double d) {
        System.out.println("Integer-Double");
    }
    
    // Method that accepts double and integer
    public static void method(double d, int i) {
        System.out.println("Double-Integer");
    }

    public static void main(String[] args) {
        // method call by passing integer and double
        method(2, 2.0);
        // method call by passing double and integer
        method(2.0, 2);
        // method call by passing both integers
        
        // Ambiguous error
        // method(2, 2);
        // method(2.0, 2.0);
    }
}
