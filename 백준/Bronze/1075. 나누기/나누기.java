import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        n = (n/100)*100; // 가장 뒤 두자리 초기화

        int m = Integer.parseInt(br.readLine());

        String ans ="";

        for (int i = 0; i < 100; i++) {
            int temp = n;
            temp+=i;

            if(temp%m==0){
                temp%=100;
                if(temp<10) ans = "0" + String.valueOf(temp);
                else ans = String.valueOf(temp);
                break;
            }
        }

        bw.write(ans);

        bw.flush();
        bw.close();
        br.close();
    }
}