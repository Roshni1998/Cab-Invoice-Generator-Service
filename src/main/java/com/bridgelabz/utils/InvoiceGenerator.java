package com.bridgelabz.utils;
/*
 * @author ROSHNI
 * Cab Invoice Generator Service
 *
 *  */

import com.bridgelabz.model.User;
import com.bridgelabz.service.InvoiceSummary;
import com.bridgelabz.model.Ride;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    private static Map<User, List<Ride>> invoiceDetail = new HashMap<>();

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_MINUTE);
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    // Add 
    public void addUserRideDetails(User user1, Ride[] rides) {
        List<Ride> rideList = Arrays.asList(rides);
        if(invoiceDetail.containsKey(user1)){
            List<Ride> rideList1 = invoiceDetail.get(user1);
            rideList1.addAll(rideList);
            invoiceDetail.put(user1, rideList1);
        }else
            invoiceDetail.put(user1, rideList);
    }

    public List<Ride> getRideUserDetails(User user1){
        if(invoiceDetail.containsKey(user1)){
            return invoiceDetail.get(user1);
        }
        return null;
    }
}
