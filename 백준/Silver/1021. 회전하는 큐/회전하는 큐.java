import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1021
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 처음 포함되어 있던 수
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++){
            deque.add(i);
        }

        // 뽑을 수
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i=0; i<m; i++){
            int x = arr[i];
            int size = deque.size();
            int index = deque.indexOf(arr[i]);
            if(size/2 < index){
                for(int j=0; j<size-index; j++){
                    int ak = deque.pollLast();
                    deque.addFirst(ak);
                    count++;
                }
            }else{
                for(int j=0; j<index; j++){
                    int a1 = deque.pollFirst();
                    deque.addLast(a1);
                    count++;
                }
            }

            deque.pollFirst();
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
    - test case
    10 3
    2 9 5

    - process
    count -> deque
    1 -> 2 3 ... 10 1
    2out  -> 3 ... 10 1     (9 index:6, size: 9)
    2 -> 1 3 ... 9 10
    3 -> 10 1 ... 8 9
    4 -> 9 10 ... 7 8
    9out -> 10 1 3 4 5 6 7 8
    ...

    - sol
    뽑아내야 하는 수를 처음으로 오게해야함
    size/2 < 뽑아내야 하는 수 index -> 3번 연산, size-index번
    size/2 >= 뽑아내야 하는 수 index -> 2번 연산, index번
 */