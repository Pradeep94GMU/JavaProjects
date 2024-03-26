package parkinglot;

public class Vehicle {
  private String id; // Unique identifier for the vehicle
  private String type; // Type of vehicle (Car, Bike, Truck, etc.)
  private String size; // Size of the vehicle (Small, Medium, Large)

  public Vehicle(String id, String type, String size) {
    this.id = id;
    this.type = type;
    this.size = size;
  }

  // Getters
  public String getId() { return id; }
  public String getType() { return type; }
  public String getSize() { return size; }
}
