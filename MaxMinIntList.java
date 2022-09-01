import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @abstract_properties
 * @object
 * 
 */
public class MaxMinIntList extends ArrayList<Integer> {

    public Object getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).intValue() < min) {
                min = this.get(i);
            }
        }
        return min;
    }

    public Object getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).intValue() > max) {
                max = this.get(i);
            }
        }
        return max;
    }
}
