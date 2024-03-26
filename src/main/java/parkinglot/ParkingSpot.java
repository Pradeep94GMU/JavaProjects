package parkinglot;

public class ParkingSpot {
    private String id; // Unique identifier for each parking spot
    private String size; // Size of the spot (Small, Medium, Large)
    private String location; // Physical location within the parking lot
    private boolean isOccupied; // Indicates whether the spot is currently occupied
    private Vehicle currentVehicle; // The vehicle currently occupying the spot, if any

    public ParkingSpot(String id, String size, String location) {
        this.id = id;
        this.size = size;
        this.location = location;
        this.isOccupied = false; // Initially, the spot is not occupied
        this.currentVehicle = null; // Initially, no vehicle is occupying the spot
    }

    // Assign a vehicle to this parking spot
    public void assignVehicle(Vehicle vehicle) {
        if (!isOccupied) {
            this.currentVehicle = vehicle;
            this.isOccupied = true;
        } else {
            System.out.println("Parking spot is already occupied.");
        }
    }

    // Remove the vehicle from this parking spot
    public void removeVehicle() {
        if (isOccupied) {
            this.currentVehicle = null;
            this.isOccupied = false;
        } else {
            System.out.println("Parking spot is already empty.");
        }
    }

    // Check if the parking spot is available
    public boolean isAvailable() {
        return !isOccupied;
    }

    // Getters
    public String getId() { return id; }
    public String getSize() { return size; }
    public String getLocation() { return location; }
    public boolean getIsOccupied() { return isOccupied; }
    public Vehicle getCurrentVehicle() { return currentVehicle; }
}

