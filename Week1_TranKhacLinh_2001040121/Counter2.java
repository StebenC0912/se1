package Week1_TranKhacLinh_2001040121;
public class Counter2 extends Counter {

    /**
     * @effects: Make this contain 0
     */

    int count;

    public Counter2() {
        this.count = 0;
    }

    /**
     * @modifies this
     * @effects: Makes this contain twice its current value
     * 
     */
    public void incr() {
        count *= 2;
    }

    /**
     * Counter2 is a legitimate subtype of Counter. Counter2 holds for a subtype of Counter that is icr.
     * 
     * 
     */

     public static void main(String[] args) {
        Counter c = new Counter2();
        c.incr();
        System.out.println(c.get());

     }
}
