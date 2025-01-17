import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int cycle = n;
        

        do{
            cycle = (cycle%10)*10 + ((cycle/10+cycle%10)%10);
            count++;
        }while(cycle!=n);

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}