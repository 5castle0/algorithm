import java.io.*;

// 6588
public class Main {

    static int N = 1000001;
    static boolean[] prime = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=2; i<N; i++){
            prime[i] = true;
        }

        // 소수 판정
        for(int i=2; i<=Math.sqrt(N); i++){
            for(int j=2; j*i<N; j++){
                prime[i*j] = false;
            }
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            if(n==0){
                break;
            }

            for(int i=0; i<N/2; i++){
                if(prime[i]){
                    if(n-i>0 && prime[n-i]){
                        bw.write(n + " = " + i + " + " + (n-i) + "\n");
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                bw.write("Goldbach's conjecture is wrong.");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}