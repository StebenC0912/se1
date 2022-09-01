package tut1;

class Vehicle {
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;
    private int seatingCapacity;
    private String registrationNumber;

    public Vehicle(String name, double width, double height, double length, double weight, int seatingCapacity,
            String registrationNumber) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.seatingCapacity = seatingCapacity;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    public boolean validateWeight() {
        if (this.weight <= 0) {
            return false;
        }
        return true;
    }

    public boolean validateSeatingCapacity() {
        if (this.seatingCapacity <= 1) {
            return false;
        }
        return true;
    }
    public boolean validateRegistrationNumber(){
        if (this.registrationNumber.length() < 9) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" [height=" + height + ", length=" + length + ", name=" + name + ", registrationNumber="
                + registrationNumber + ", seatingCapacity=" + seatingCapacity + ", weight=" + weight + ", width="
                + width + "]";
    }
    
}