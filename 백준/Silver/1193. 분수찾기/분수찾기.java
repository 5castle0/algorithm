import java.io.*;

// 1193
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int diagonal = 1;
        int sum = 1;

        while(true){
            if(sum>=x) break;

            diagonal++;
            sum+=diagonal;
        }

        int total = diagonal + 1; // 분모 + 분자

        int a = sum - x + 1 ;
        int b = total - a;

        // b/a 또는 a/b 결정
        if (diagonal % 2 == 0) {
            // b/a
            bw.write(b + "/" + a);
        } else {
            // a/b
            bw.write(a + "/" + b);
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}