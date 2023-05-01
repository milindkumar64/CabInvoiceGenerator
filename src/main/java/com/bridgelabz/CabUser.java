package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CabUser {

	int userId;
	List<Integer[]> fareDetails = new ArrayList<>();
	HashMap <String,String> invoice = new HashMap<>();
	
	public final static int FARE_PER_KM = 10;
	public final static int MIN_FARE = 5;

	public  int calculateFare(int timeInMinuts, int distanceCovered) {
		int cost = MIN_FARE;
		if (timeInMinuts < 1) {

			return cost;
		} else {
			cost = (distanceCovered * FARE_PER_KM) + (1 * timeInMinuts);
			return cost;
		}
	}

	public  int calculateFareForMultipleRides(List<Integer[]> fareDetails) {
		int cost = 0;
		int totalCost = 0;
		for (Integer[] fare : fareDetails) {
			cost = calculateFare(fare[0], fare[1]);
			totalCost = +cost;
		}
		return totalCost;
	}

	public  void invoiceGenerator() {
		
		int totalRide = this.fareDetails.size();
		System.out.println("number of rides: "+totalRide);
		
		int totalFare=calculateFareForMultipleRides(this.fareDetails);
		System.out.println("total fares : "+totalFare);

		double averageFarePerRide= totalFare/totalRide;
		System.out.println("average fare per ride :"+averageFarePerRide);
		
		this.invoice.put("totalRide",String.valueOf(totalRide));
		this.invoice.put("totalFare",String.valueOf(totalFare));
		this.invoice.put("averageFarePerRide", String.valueOf(averageFarePerRide));
		
		
	}
}
