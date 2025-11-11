import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/* 최소동작으로 문자열 S를 E로 만들기
동작1. S 맨뒤에 ‘X’ 추가 / 동작2. S를 뒤집고 맨뒤에 ‘Y’ 추가 */

// 메모리: 94,208kb / 실행시간: 192ms / 코드길이: 2,222 
 
class Solution {
    private static final String Y = "Yes";
    private static final String N = "No";
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/D3_20955_StringXY1.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T;
        T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sbS = new StringBuilder(br.readLine());
            StringBuilder sbE = new StringBuilder(br.readLine());
            bw.write("#" + test_case + " " + check(sbS,sbE) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
     
    private static String check(StringBuilder S, StringBuilder E) {
        Queue<StringBuilder> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new StringBuilder(E));
        visited.add(E.toString());
         
        while (!queue.isEmpty()) {
            StringBuilder cur = queue.poll();
 
            if (cur.toString().equals(S.toString())) return Y;
            if (cur.length() < S.length()) continue;
 
            if (cur.charAt(cur.length() - 1) == 'X') {
                StringBuilder next = new StringBuilder(cur);
                next.deleteCharAt(next.length() - 1);
                String nextStr = next.toString();
                if (!visited.contains(nextStr)) {
                    visited.add(nextStr);
                    queue.add(next);
                }
            }
 
            if (cur.charAt(cur.length() - 1) == 'Y') {
                StringBuilder next = new StringBuilder(cur);
                next.deleteCharAt(next.length() - 1).reverse();
                String nextStr = next.toString();
                if (!visited.contains(nextStr)) {
                    visited.add(nextStr);
                    queue.add(next);
                }
            }
        }
        return N;
    }
}
