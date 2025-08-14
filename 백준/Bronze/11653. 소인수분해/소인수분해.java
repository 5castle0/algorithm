import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=2; i<=n; i++){
            while(n%i == 0){
                bw.write(i +"\n");
                n/=i;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}