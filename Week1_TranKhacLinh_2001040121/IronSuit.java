package Week1_TranKhacLinh_2001040121;

public class IronSuit extends Vehicle {
    public IronSuit(String name, double width, double height, double length, double weight, int seatingCapacity,
            String register, String placeA, String placeB) {
        super(name, width, height, length, weight, seatingCapacity, register, placeA, placeB);
    }
    private String material;
    
    public void Fly(String placeA, String placeB) {
        int millies = 300; // 0.3 second
        System.out.print("IronSuit is flying from " + placeA);
        try {
            Thread.sleep(millies); // pause
            // wake up: do something
            System.out.print(".");
        } catch (InterruptedException e) {
            // Ignore Exception handling
        }
        System.out.println(placeB);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
