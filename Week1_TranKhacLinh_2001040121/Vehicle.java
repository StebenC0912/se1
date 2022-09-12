package Week1_TranKhacLinh_2001040121;

class Vehicle {
    private String register;
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;
    private int seatingCapacity;
    private String placeA;
    private String placeB;

    public Vehicle(String name, double width, double height, double length, double weight, int seatingCapacity,String register, String placeA, String placeB) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.seatingCapacity = seatingCapacity;
        this.register = register;
        this.placeA = placeA;
        this.placeB = placeB;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getPlaceA() {
        return placeA;
    }

    public void setPlaceA(String placeA) {
        this.placeA = placeA;
    }

    public String getPlaceB() {
        return placeB;
    }

    public void setPlaceB(String placeB) {
        this.placeB = placeB;
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

    public String registrationNumber(String register) {
        return register;
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
    protected boolean validateRegistrationNumber(String register) {
        boolean validate = false;
        if (registrationNumber(register).length() <= 12 && registrationNumber(register).length() >= 5) {
            for (int i = 0; i < registrationNumber(register).length(); i++) {
                if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                    if (Character.isDigit(registrationNumber(register).charAt(i))) {
                        validate = true;
                    } else {
                        validate = false;
                        break;
                    }
                } else {
                    if (Character.isLetter(registrationNumber(register).charAt(i))) {
                        validate = true;
                    } else {
                        validate = false;
                        break;
                    }
                }
            }
        } else {
            validate = false;
        }
        return validate;
    }
    
    public void travel() {
        System.out.println(
                "The type of vehicle " + this.getClass().getSimpleName() + ", the two points are: " + this.getPlaceA()
                        + ", " + this.getPlaceB() + ". " + "The number of passenger" + this.getSeatingCapacity());
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" [height=" + height + ", length=" + length + ", name=" + name + ", registrationNumber="
                + register + ", seatingCapacity=" + seatingCapacity + ", weight=" + weight + ", width="
                + width + "]";
    }
    
}