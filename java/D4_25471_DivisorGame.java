import java.io.*;
import java.util.*;

public class case_25471_game {
	static Character result;
	static int turn;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_for_25471.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			turn = 0;
			result = (game(N)) ? 'A' : 'B';
			bw.write(result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	static boolean game(long N) {
		if ((N & 1) == 1) return false;
		else {
			if ((N & (N - 1)) == 0) {
				int x = 0;
				while (N % 2 == 0) {
				    N /= 2;
				    x++;
				}
				if((x & 1) == 1) return false;
			}
		}
		return true;
	}
}
