import java.io.*;
import java.util.*;

/* 로봇 제어 명령문이 주어진다. ex) "LR???RRLRLL??RLRRR"
최종 위치가 원점과 가장 멀어지도록 ?를 대체했을때 원점과의 거리 출력 */
// 단순처리 / 메모리: 25,344kb / 실행시간: 82ms / 코드길이: 1,090

public class case_24001_basic_robotPush {
	public static final char CH_L = 'L';
	public static final char CH_R = 'R';
	public static final boolean REPLACE_R = true;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_24001.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			int case1 = check(input, REPLACE_R);
			int case2 = check(input, !REPLACE_R);
			bw.write((case1 >= case2) ? case1 + "\n" : case2 + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int check(String input, boolean type) {
		int location = 0, max = 0;
		char target;
		if (type) target = CH_R;
		else target = CH_L;
		for (char c : input.toCharArray()) {
			if (c == target) location++;
			else location--;
			if (Math.abs(location) > max) max = Math.abs(location);
		}
		return max;
	}
}
