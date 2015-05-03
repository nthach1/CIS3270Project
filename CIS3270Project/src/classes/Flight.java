package classes;

import java.util.*;

public class Flight {

	private String flightNumber;

	private String origin;

	private String destination;

	private String departureDate;
	
	private String departureTime;
	
	private String arrivaleDate;
	
	private String arrivaleTime;

	private String airlines;
	
	private int passengers;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivaleDate() {
		return arrivaleDate;
	}

	public void setArrivaleDate(String arrivaleDate) {
		this.arrivaleDate = arrivaleDate;
	}

	public String getArrivaleTime() {
		return arrivaleTime;
	}

	public void setArrivaleTime(String arrivaleTime) {
		this.arrivaleTime = arrivaleTime;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

}
