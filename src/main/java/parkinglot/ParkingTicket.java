package parkinglot;

import java.time.LocalDateTime; // Import the LocalDateTime class

public class ParkingTicket {
    private String id;
    private String vehicleId;
    private String parkingSpotId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalCharge;

    public ParkingTicket(String id, String vehicleId, String parkingSpotId) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.parkingSpotId = parkingSpotId;
        this.startTime = LocalDateTime.now(); // Ticket start time is set at creation
        this.endTime = null; // End time is null initially
        this.totalCharge = 0.0; // Total charge is set when the ticket is closed
    }

    // Method to calculate total charge based on the parking duration and rate policy
    public void calculateCharge(double ratePerHour) {
        if (endTime != null) {
            long duration = java.time.Duration.between(startTime, endTime).toHours();
            this.totalCharge = duration * ratePerHour;
        }
    }

    // Setters and Getters
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public String getId() { return id; }
    public String getVehicleId() { return vehicleId; }
    public String getParkingSpotId() { return parkingSpotId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public double getTotalCharge() { return totalCharge; }
}
