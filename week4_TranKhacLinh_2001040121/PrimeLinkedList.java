package week4_TranKhacLinh_2001040121;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PrimeLinkedList extends LinkedList<Integer> {
    public PrimeLinkedList() {
        super();
    }

    public class primeIterator implements Iterator<Integer> {
        private int index = 0;

        public boolean hasNext() {
            for (int i = index; i < PrimeLinkedList.this.size(); i++) {
                if (isPrime(get(i))) {
                    return true;
                }
            }
            return false;
        }

        public Integer next() {
            for (int i = index; i < PrimeLinkedList.this.size(); i++) {
                if (isPrime(PrimeLinkedList.this.get(i))) {
                    index = i + 1;
                    return PrimeLinkedList.this.get(i);
                }
            }
            return null;
        }

        public boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public Iterator<Integer> primeIterator(List numbers) {
            Iterator copy = numbers.iterator();
            List<Integer> prime = new LinkedList<>();
            while (copy.hasNext()) {
                prime.add((Integer) copy.next());
            }
            return prime.iterator();
        }
    }
}
