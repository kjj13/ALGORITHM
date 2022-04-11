package year2022.month01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	static int N, max, min;
	static int[] arr, arrTmp, op, opTmp;
//	static char[] op,opTmp;
	static boolean[] arrCheck, opCheck;
//	static char[] operation = {'+','-','*','/'};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arrTmp = new int[N];
		op = new int[N - 1];
		opTmp = new int[N - 1];
		arrCheck = new boolean[N];
		opCheck = new boolean[N - 1];

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				op[cnt++] = i;
			}
		}

		perm2(0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void perm2(int target) {
		if (target == N-1) {
			int result = arr[0];
			for (int i = 0; i < N - 1; i++) {
				if (opTmp[i] == 0)
					result += arr[i + 1];
				else if (opTmp[i] == 1)
					result -= arr[i + 1];
				else if (opTmp[i] == 2)
					result *= arr[i + 1];
				else if (opTmp[i] == 3)
					result /= arr[i + 1];
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for (int i = 0; i < N - 1; i++) {
			if (opCheck[i])
				continue;

			opCheck[i] = true;
			opTmp[target] = op[i];
			perm2(target + 1);
			opCheck[i] = false;
		}
	}

	private static void perm(int target) {
		if (target == N - 1) {
			perm1(0);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (opCheck[i])
				continue;

			opCheck[i] = true;
			opTmp[target] = op[i];
			perm(target + 1);
			opCheck[i] = false;
		}
	}

	private static void perm1(int target) {
		if (target == N) {
			int result = arrTmp[0];
			for (int i = 0; i < N - 1; i++) {
				if (opTmp[i] == 0)
					result += arrTmp[i + 1];
				else if (opTmp[i] == 1)
					result -= arrTmp[i + 1];
				else if (opTmp[i] == 2)
					result *= arrTmp[i + 1];
				else if (opTmp[i] == 3)
					result /= arrTmp[i + 1];
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (arrCheck[i])
				continue;

			arrCheck[i] = true;
			arrTmp[target] = arr[i];
			perm1(target + 1);
			arrCheck[i] = false;
		}
	}
}
