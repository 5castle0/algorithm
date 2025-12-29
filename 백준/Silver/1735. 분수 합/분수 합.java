import java.io.*;
import java.util.StringTokenizer;

// 1735
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // a/b
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // c/d
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int child = a*d + b*c;
        int mother = b*d;

        int gcd = gcd(mother, child);

        bw.write(child/gcd + " " + mother/gcd);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
