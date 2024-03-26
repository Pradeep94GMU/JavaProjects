package parkinglot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
  private String id;
  private Map<String, ParkingSpot> parkingSpots;
  private double ratePerHour; // Simplified rate policy for this example

  public ParkingLot(String id, double ratePerHour) {
    this.id = id;
    this.parkingSpots = new HashMap<>();
    this.ratePerHour = ratePerHour;
  }

  // Method to add parking spots to the lot
  public void addParkingSpot(ParkingSpot spot) {
    parkingSpots.put(spot.getId(), spot);
  }

  // Finds an appropriate available spot for the vehicle and issues a ParkingTicket
  public ParkingTicket parkVehicle(Vehicle vehicle) {
    for (ParkingSpot spot : parkingSpots.values()) {
      if (spot.isAvailable() && spot.getSize().equals(vehicle.getSize())) {
        spot.assignVehicle(vehicle);
        ParkingTicket ticket = new ParkingTicket(generateTicketId(), vehicle.getId(), spot.getId());
        return ticket;
      }
    }
    return null; // No available spot found
  }

  // Releases the vehicle, calculates the charge, and closes the ticket
  public void releaseVehicle(ParkingTicket ticket) {
    ParkingSpot spot = parkingSpots.get(ticket.getParkingSpotId());
    spot.removeVehicle();
    ticket.setEndTime(LocalDateTime.now());
    ticket.calculateCharge(ratePerHour);
  }

  // Utility method to generate a unique ticket ID (simplified for example)
  private String generateTicketId() {
    return "TICKET_" + System.currentTimeMillis();
  }

  // Finds the nearest or most suitable available parking spot for a vehicle
  // This example simplifies the logic for finding an available spot
  public ParkingSpot findAvailableSpot(Vehicle vehicle) {
    for (ParkingSpot spot : parkingSpots.values()) {
      if (spot.isAvailable() && spot.getSize().equals(vehicle.getSize())) {
        return spot;
      }
    }
    return null; // No available spot found
  }

  // Getters
  public String getId() { return id; }
  public Map<String, ParkingSpot> getParkingSpots() { return parkingSpots; }
}

