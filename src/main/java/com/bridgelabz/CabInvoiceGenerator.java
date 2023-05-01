package com.bridgelabz;

import java.util.*;

public class CabInvoiceGenerator {

	static List<CabUser> cabUserList = new ArrayList<>();

	static void addCabUser() {
		CabUser user = new CabUser();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please give a UserId:");
		user.userId = sc.nextInt();
		cabUserList.add(user);
		System.out.println("New Cab user has been successfully added!");
		System.out.println("want to add ride: press '1' else any Integer");
		int check= sc.nextInt();
		if(check == 1);{
			addRides(user.userId);
		}
	}

	static void addRides(int userId) {
		Scanner sc = new Scanner(System.in);
		int check = 1;
		for (CabUser cabUser : cabUserList) {
			if (userId == cabUser.userId) {
				while (check == 1) {
					System.out.println("Time Taken in minuts :");
					int time = sc.nextInt();
					System.out.println("Distance covered:");
					int distance = sc.nextInt();
					cabUser.fareDetails = new ArrayList<>();
					cabUser.fareDetails.add(new Integer[] { time, distance });
					System.out.println("Ride successfully added : want to add new ride press '1' else any Integer");
					check = sc.nextInt();
				}
			}
		}
	}
	static int calculateBill(int userId) {
		int cost=0;
		for (CabUser cabUser : cabUserList) {
			if (userId == cabUser.userId) {
				cost = cabUser.calculateFareForMultipleRides(cabUser.fareDetails);
			}
		}
		
		return cost;	
	}

	public static void main(String[] args) {

		int check = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please add new can User :");
		while (check == 1) {
			addCabUser();
			System.out.println("Want to add another user press '1' else any Integer:");
			check = sc.nextInt();
		}
		System.out.println("Welcome to invoice Generator..");
		System.out.println("Please Enter UserId :");
		int userId = sc.nextInt();
		System.out.println("total costs of all the rides : "+calculateBill(userId));
		
	}

}
