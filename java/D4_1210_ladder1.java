import java.io.*;
import java.util.*;

/* 100x100 사다리게임의 출발지 확인 */
// 시뮬레이션 / 메모리: 36,352kb / 실행시간: 131ms / 코드길이: 1,479

public class case_1210_Ladder1 {
	static int TC = 100;
	static int[][] ladder = new int[TC][TC];
	static int axis, idx;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_1210.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int tc = 1; tc <= 10; tc++) {
			// TC번호
			int T = Integer.parseInt(br.readLine());
			// 파싱
			for (int i = 0; i < TC; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < TC; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 도착지, 세로간선 확인
			List<Integer> ladderV = new ArrayList<>();
			for (int i = 0; i < TC; i++) {
				if(ladder[TC - 1][i] != 0) {
					if(ladder[TC - 1][i] == 1) ladderV.add(i);
					if(ladder[TC - 1][i] == 2) {
						ladderV.add(i);
						idx = ladderV.size() - 1;
						axis = i;
					}
				}
			}
			// 사다리
			for (int i = TC-2; i >= 0; i--) {
				if (axis - 1 < 0) { 
					if (ladder[i][axis + 1] == 1) idx++;
				} else if (axis + 1 >= TC) {
					if (ladder[i][axis - 1] == 1) idx--;
				} else {
					if (ladder[i][axis - 1] == 1) idx--;
					else if (ladder[i][axis + 1] == 1) idx++;
				}
				axis = ladderV.get(idx);
			}
			
			bw.write("#" + T + " " + axis + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
