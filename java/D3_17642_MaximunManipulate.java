import java.util.*;
import java.io.*;

/* 주어지는 A에서 임의의 소수를 더하거나 B에서 임의의 소수를 빼서, A B 값이 같아질때까지 조작, 조작 횟수를 최대로 만드는 방법 */
// 메모리: 25,472 kb / 실행시간: 78ms / 코드길이: 860

public class case_17642 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_17642.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long inputA = Long.parseLong(st.nextToken());
			long inputB = Long.parseLong(st.nextToken());
			long result = 0;
			if (inputA != inputB) result = manipulate(inputA, inputB);
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

  // 조작횟수가 최대가 되려면 가장 작은 소수로 연산해야함
	private static long manipulate(long a, long b) {
		if (b - a <= 1) return -1;
		return (b - a) / 2;
	}
}
