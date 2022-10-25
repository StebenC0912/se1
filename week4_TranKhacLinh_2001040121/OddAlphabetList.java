package week4_TranKhacLinh_2001040121;

import java.util.ArrayList;
import java.util.Iterator;

public class OddAlphabetList {
/* @effect: list contain all alphabet whose code is odd number.
*/
    public static void OddAlphabetList(){
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        ArrayList<Character> code = new ArrayList<>();
        for (char c : alphabet) {
            if (c % 2 == 0) {
                code.add(c);
            }
        }
        Iterator<Character> charCode = code.iterator();
        while (charCode.hasNext()) {
            System.out.println(charCode.next()+ " ");
        }
    }
}
