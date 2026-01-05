import java.io.*;
import java.util.*;

// 1966
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            List<Integer> priorityList = new ArrayList<>();
            int pIndex = 0; // priorityList에서 쓰일 인덱스
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i, priority});
                priorityList.add(priority);
            }

            Collections.sort(priorityList, Collections.reverseOrder());

            int count = 0; // 몇번째로 인쇄되는지 기록
            while (!queue.isEmpty()) {
                int[] pop = queue.poll();
                if(pop[1]==priorityList.get(pIndex)){ // 우선순위 문서일 때
                    if(pop[0] == m){ // 특정 문서일 때
                        count++;
                        bw.write(count + "\n");
                        break;
                    }
                    else{
                        count++;
                        pIndex++;
                    }
                }else{ // 우선순위 문서가 아닐 때
                    queue.add(pop);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}