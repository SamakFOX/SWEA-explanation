import java.io.*;
import java.util.*;

public class case_2806_nqueen_dfs {
	static int N, answer;
	static boolean[] col, diag1, diag2;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_2806.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			answer = 0;
			col = new boolean[N]; // 세로열
			diag1 = new boolean[2*N-1]; // 순방향 대각선 (/)
			diag2 = new boolean[2*N-1]; // 역방향 대각선 (\)
			
			dfs(0);
			
			bw.write("#" + tc + " " + answer + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 매 열마다 배치 후 탐색
	static void dfs(int row) {
		if (row == N) {
			answer++;
			return;
		}
		
		for (int c = 0; c < N; c++) {
			if (col[c] || diag1[row+c] || diag2[row-c+N-1]) continue;
			// 조작결과 임시반영
			col[c] = true;
			diag1[row+c] = true;
			diag2[row-c+N-1] = true;
			
			dfs(row + 1);
			
			// 되돌아오며 복구
			col[c] = false;
			diag1[row+c] = false;
			diag2[row-c+N-1] = false;
		}
	}
}
