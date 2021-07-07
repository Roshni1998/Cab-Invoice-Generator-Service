package com.bridgelabz.utils;

public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_MINUTE);
        return totalFare;
    }
}
