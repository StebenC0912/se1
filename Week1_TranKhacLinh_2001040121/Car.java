package Week1_TranKhacLinh_2001040121;

public class Car extends Vehicle {
    public Car(String name, double width, double height, double length, double weight, int seatingCapacity,String register, String placeA, String placeB){
        super(name, width, height, length, weight, seatingCapacity, register, placeA, placeB);
    }
    public boolean validateLength() {
        if (this.getLength() < 1.5 || this.getLength() > 3.5)
            return false;
        return true;
    }

    @Override
    public boolean validateRegistrationNumber(String register) {
        if (this.registrationNumber(register).length() > 12 && this.registrationNumber(register) != null) {
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
