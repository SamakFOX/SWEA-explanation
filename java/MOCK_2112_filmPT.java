import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class case_2112_dfs {
	static int count = 0;
	static int[][] film;
	static int D, W ,K;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_2112.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T =  Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			} // TC별 배열 파싱
			
			if (K == 1) {
				count = 0; // K가 1이면 이미 Pass
			} else {
				count = K; // K번 투약하면 무조건 Pass
				dfs(0, 0); // 트리 루트 지정 : DFS
			}
			
			bw.write("#" + tc + " " + count + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

  // dfs 재귀
	static void dfs(int row, int dcount) {
		if (dcount >= count) return;
		
		if (row == D) {
			if (check(film, D, W, K)) {
				count = Math.min(count, dcount);
			}
			return;
		}
		
		dfs(row + 1, dcount); // 리프노드까지 진입 (체크)
		
		int[] bakList = film[row].clone(); // 약품 처리 전 배열 백업
		
		Arrays.fill(film[row], 0); // A약품 처리
		dfs(row + 1, dcount + 1);
		
		Arrays.fill(film[row], 1); // B약품 처리
		dfs(row + 1, dcount + 1);
		
		film[row] = bakList; // 복구
	}

  // 조건 판별 TF
	static boolean check(int[][] film, int D, int W, int K) {
		for (int col = 0; col < W; col++) {
			int maxAcc = 1;
			int curAcc = 1;
			
			for (int row = 1; row < D; row++) {
				if (film[row][col] == film[row-1][col]) curAcc++;
				else curAcc = 1;
				if (curAcc > maxAcc) maxAcc = curAcc;
				// 현재열 최대누적 체크
				if (maxAcc > K) break; // 해당 열이 조건충족하면 다음열로
			}
			if (maxAcc < K) return false; // 해당 열이 미달이면 false 반환
		}
		return true; // 모든열이 조건충족했으므로 true 반환
	}

}
