package com.bridgelabz;

import com.bridgelabz.model.User;
import com.bridgelabz.service.InvoiceSummary;
import com.bridgelabz.model.Ride;
import com.bridgelabz.utils.InvoiceGenerator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGeneratorTest {
    public static InvoiceGenerator invoiceGenerator;

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary= new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @BeforeClass
    public static void setUp(){
        invoiceGenerator = new InvoiceGenerator();
        User user1 = new User(101);
        User user2 = new User(102);
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        Ride[] ride2 = { new Ride(1.0, 4),
                new Ride(0.1, 2)};
        invoiceGenerator.addUserRideDetails(user1, rides);
        invoiceGenerator.addUserRideDetails(user2, ride2);
    }

    @Test
    public void givenAUserId_InvoiceService_GetsTheListOfRides_ReturnsTheInvoiceSummary(){
        List<Ride> rideUserDetails = invoiceGenerator.getRideUserDetails(new User(102));
        rideUserDetails.forEach(ride -> System.out.println(ride.toString()));
    }
}
