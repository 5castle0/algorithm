import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// 1747
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = N; ; i++) {
            if(N==1){
                bw.write("2");
                break;
            }
            if (checkPrime(i) && checkPalindrome(i)) {
                bw.write(String.valueOf(i));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindrome(int n) {
        Deque<Integer> arr = new ArrayDeque<>();

        while (n >= 10) {
            arr.add(n % 10);
            n /= 10;
        }

        arr.add(n);

        while (!arr.isEmpty() && arr.size() != 1) {
            int front = arr.pollFirst();
            int last = arr.pollLast();

            if (front != last) {
                return false;
            }
        }

        return true;
    }
}

