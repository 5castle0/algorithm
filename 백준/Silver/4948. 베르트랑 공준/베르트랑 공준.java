import java.io.*;

// 4948
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 123456*2 + 1;
        boolean[] notPrime = new boolean[123456*2 + 1];
        notPrime[1] = false; // 1은 소수 아님

        for(int i=2; i<Math.sqrt(size); i++){
            for(int j=2; j*i<=size; j++){
                notPrime[j*i] = true;
            }
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                break;
            }

            int count = 0;
            for(int i=n+1; i<=2*n; i++){
                if(!notPrime[i]) count++;
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}