package Week1_TranKhacLinh_2001040121;

public class IronSuit extends Vehicle {
    public IronSuit(String name, double width, double height, double length, double weight, int seatingCapacity,
            String register, String placeA, String placeB) {
        super(name, width, height, length, weight, seatingCapacity, register, placeA, placeB);
    }

    public IronSuit() {
        super();
    }
    private String material;
    
    public void Fly(String placeA, String placeB, int distance) {
        int millies = 300; // 0.3 second
        System.out.print(placeA);
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(millies); // pause
                // wake up: do something
                System.out.print(".");
            } catch (InterruptedException e) {
                // Ignore Exception handling
            }
        }
        
        System.out.print(placeB);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    

}
