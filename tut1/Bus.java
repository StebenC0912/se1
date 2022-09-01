package tut1;

public class Bus extends Vehicle {
    public Bus(String name, double width, double height, double length, double weight, int seatingCapacity,
            String registrationNumber) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }
    public boolean validateLength(){
        if (this.getLength() < 4.0 || this.getLength() > 10.0) return false;
        return true;
    }
    @Override
    public boolean validateRegistrationNumber(){
        if (this.getRegistrationNumber().length() > 12 && this.getRegistrationNumber() != null) {
            return false;
        }
        return true;
    }
    @Override
    public boolean validateWeight(){
        if (this.getWeight() < 5000.0 || this.getWeight() > 20000.0) {
            return false;
        }
        return true;
    }
    
}
