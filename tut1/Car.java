package tut1;

public class Car extends Vehicle {
    public Car(String name, double width, double height, double length, double weight, int seatingCapacity,
            String registrationNumber) {
        super(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }

    public boolean validateLength() {
        if (this.getLength() < 1.5 || this.getLength() > 3.5)
            return false;
        return true;
    }

    @Override
    public boolean validateRegistrationNumber() {
        if (this.getRegistrationNumber().length() > 8 || this.getRegistrationNumber().length() < 6) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validateWeight() {
        if (this.getWeight() < 1000.0 || this.getWeight() > 2000.0) {
            return false;
        }
        return true;
    }
}
