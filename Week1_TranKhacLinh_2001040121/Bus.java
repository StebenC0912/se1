package Week1_TranKhacLinh_2001040121;

public class Bus extends Vehicle {
    public Bus(String name, double width, double height, double length, double weight, int seatingCapacity,String register, String placeA, String placeB){
        super(name, width, height, length, weight, seatingCapacity, register, placeA, placeB);
    }
    public boolean validateLength(){
        if (this.getLength() < 4.0 || this.getLength() > 10.0) return false;
        return true;
    }
    @Override
    public boolean validateRegistrationNumber(String register){
        if (this.registrationNumber(register).length() > 12 && this.registrationNumber(register) != null) {
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
