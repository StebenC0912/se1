package week4_TranKhacLinh_2001040121;

public class First10Primes {
    public static boolean isPrime(int prime) {
        if (prime < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void First10Primes(){
        int[] primes = new int[10];
        int count = 0;
        int prime = 2;
        while (count < 10) {
            if (isPrime(prime)) {
                primes[count] = prime;
                count++;
            }
            prime++;
        }
        for (int i : primes) {
            System.out.println(primes[i] + " ");
        }
    }
}
