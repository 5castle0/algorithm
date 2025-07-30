import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "#" + br.readLine() + "#";
        String find = br.readLine();

        String[] split = str.split(find);
        bw.write(String.valueOf(split.length-1));

        bw.flush();
        bw.close();
        br.close();
    }

}
