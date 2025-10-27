import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String newStr = str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=","#");

        bw.write(String.valueOf(newStr.length()));

        bw.flush();
        bw.close();
        br.close();

    }

}