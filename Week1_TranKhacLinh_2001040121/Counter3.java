package Week1_TranKhacLinh_2001040121;
public class Counter3 extends Counter{
    
    int n;
    public Counter3(int n){
        this.n = n;
    }

    /**
     * @modifies this
     * @effects If n > 0 add n to this.
     */

    public void incr(int n){
        if(n > 0){
            this.n = this.n + n;
        }
    }

    /**
     * Counter3 is not a legitimate subtype of Counter. 
     * The void incr() method in Counter3 is not a subtype of the void incr() method in Counter, because the method in Counter3 has a parameter.
     * 
     */
}
