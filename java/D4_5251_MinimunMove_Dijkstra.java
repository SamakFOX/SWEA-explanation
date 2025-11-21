import java.io.*;
import java.util.*;

/* 그래프 도착 최단거리 */
// 다익스트라 / 파이썬 전용문제입니다 (SWEA 테스트 불가능)
// TC 출력시 1 6 6 5 7 8 7 8 8 5 출력되면 성공

public class A_Dijkstra {
	static class Node implements Comparable<Node> {
		int to, cost;
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}	
	}
	
	// 최단거리 초기화용
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_5251_Dijkstra.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 노드그래프를 위한 2중 리스트 (인덱스 이용)
			ArrayList<ArrayList<Node>> graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.get(from).add(new Node(to, cost));
			}
			
			// 최단거리 갱신을 위한 테이블
			int[] dist = new int[N+1];
			Arrays.fill(dist, INF);
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			dist[0] = 0;
			pq.add(new Node(0, 0));
			
			while(!pq.isEmpty()) {
				Node curr = pq.poll();
				int now = curr.to;
				int nowCost = curr.cost;
				
				// 최소비용이 현재비용보다 작으면 건뛰 
				if (dist[now] < nowCost) continue;
				
				// now번째 리스트내에서 반복하며 노드 꺼냄
				for (Node next : graph.get(now)) {
					int cost = nowCost + next.cost;
					if (cost < dist[next.to]) {
						dist[next.to] = cost;
						pq.add(new Node(next.to, cost));
					}
				}
			}
			bw.write("#" + tc + " " + dist[N] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
