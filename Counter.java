    /**
     * @overview the program that is for counting
     * @attributes
     *      Integer count
     * @abstract_properties
     *      min(count) = 0
     * @object
     */

public class Counter {

    int count;

    /** @required min(count) = 0
     * @effect Make this contain 0
     * 
     * 
     */
    public Counter(){
        count = 0;
    }
    
    /**
     * @effects Return the value of this
     */
    
     public int get(){
        return count;
     }

     /**
      * @modifies this
      * @effects Increment the value of this

      */
    public void incr(){
        count++;
    }

}
