package week4_TranKhacLinh_2001040121;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IntegerLinkedList extends LinkedList<Integer>{
    public IntegerLinkedList(){
        super();
    }
    public class evenIterator implements Iterator<Integer>{
        private int index = 0;
        public boolean hasNext(){
            for (int i = index; i < IntegerLinkedList.this.size(); i++) {
                if (get(i) % 2 == 0) {
                    return true;
                }
            }
            return false;
        }
        public Integer next(){
            for (int i = index; i < IntegerLinkedList.this.size(); i++) {
                if (IntegerLinkedList.this.get(i) % 2 == 0) {
                    index = i + 1;
                    return IntegerLinkedList.this.get(i);
                }
            }
            return null;
        }
        public Iterator<Integer> evenIterator(List numbers){
            Iterator copy = numbers.iterator();
            List<Integer> even = new LinkedList<>();
            while (copy.hasNext()) {
                even.add((Integer) copy.next());
            }
            return even.iterator();
        }
    }
    
}
