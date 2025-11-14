import java.io.*;
import java.util.*;

/* 미로 최단거리 탈출 및 이동 거리 출력*/
// 파이썬 전용문제입니다 (SWEA 테스트 불가능)
// 테스트케이스로 검증 시 답은 순서대로 1,0,6,0,5 입니다.

public class case_5105_bfs_maze {
	static int N;
	static boolean[][] visited;
	static int[][] maze;
	static int[][] distance;
	static int stAxisX, stAxisY, edAxisX, edAxisY;
	static int[] defRow = {-1, 1, 0, 0};
	static int[] defCol = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_5105.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스 루프
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			maze = new int[N][N];
			distance = new int[N][N];
			int result = 0;
			
			// 테스트케이스 파싱
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < N; c++) {
					maze[r][c] = line.charAt(c) - '0'; // character -> integer
					if (maze[r][c] == 2) {
						stAxisX = r;
						stAxisY = c;
					} else if (maze[r][c] == 3) {
						edAxisX = r;
						edAxisY = c;
					}
				}
			}
			
			bfs(stAxisX, stAxisY);
			
			if (distance[edAxisX][edAxisY] != 0) result = distance[edAxisX][edAxisY] - 1;
			
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void bfs(int sRow, int sCol) {
		Queue<int[]> q = new LinkedList<>();
		
		visited[sRow][sCol] = true; // 방문처리
		distance[sRow][sCol] = 0; // 거리
		q.offer(new int[] {sRow, sCol}); // 큐에 새 좌표 삽입
		
		// 큐가 소진될때까지 반복 (도착 또는 진행불가시까지)
		while (!q.isEmpty()) {
			int[] now = q.poll(); // 큐에서 좌표 꺼냄
			int nowRow = now[0];
			int nowCol = now[1];
			
			if (maze[nowRow][nowCol] == 3) break;
			
			for (int i = 0; i < 4; i++) {
				int newRow = nowRow + defRow[i];
				int newCol = nowCol + defCol[i];
				
				if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= N) continue; // 미로바깥 건뛰
				if (maze[newRow][newCol] == 1) continue; // 벽인경우 건뛰
				if (visited[newRow][newCol]) continue; // 방문노드 건뛰
				
				visited[newRow][newCol] = true; // 방문처리
				distance[newRow][newCol] = distance[nowRow][nowCol] + 1;
				q.offer(new int[] {newRow, newCol});
			}
		}
	}
}
