import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n%2==0) {
            bw.write("CY");
        }else{
            bw.write("SK");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
