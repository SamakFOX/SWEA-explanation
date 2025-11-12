import java.util.Scanner;
import java.io.FileInputStream;

/* A += B 또는 B += A 연산으로 N을 초과시킬 때의 최소연산 수 */

// 메모리: 25,216kb / 실행시간: 83ms / 코드길이: 1,094  

class Solution {
    public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_21425.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int inA = Integer.parseInt(st.nextToken());
			int inB = Integer.parseInt(st.nextToken());
			int inN = Integer.parseInt(st.nextToken());
			int result = checkABN(inA, inB, inN);
			bw.write(result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int checkABN(int a, int b, int n) {
		int count = 0;
		while(a <= n && b <= n) {
			if (a >= b) b += a;
			else a += b;
			count++;
		}
		return count;
	}
}
