package year2022.month03;

import java.util.*;

public class P_L2_거리두기확인하기 {
	static int len = 5;
	static List<Node> list;
	static boolean[][] visit;
	static Queue<Node> Q;
	static boolean check;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		String[][] arr = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[len];
		for (int idx = 0; idx < 5; idx++) {
			list = new ArrayList<>();
			visit = new boolean[len][len];
			
			check = false;
			for (int j = 0; j < len; j++) {
				String str = places[idx][j];
				for (int c = 0; c < len; c++) {
					char ch = str.charAt(c);
					if (ch == 'P') {
						list.add(new Node(j, c));
					}
				}
			}
			if(list.isEmpty()) {
				answer[idx] = 1;
				continue;
			}

			for (int i = 0; i < list.size() - 1; i++) {
				Node a = list.get(i);
				for (int j = i + 1; j < list.size(); j++) {
					Node comp = list.get(j);
					int diff = Math.abs(a.x - comp.x) + Math.abs(a.y - comp.y);
					System.out.print(diff + " ");
					if (diff <= 2) {
						Q = new LinkedList<>();
						Q.add(a);
						visit[a.x][a.y] = true;
						if (bfs(idx, places)) {
							check = true;
							break;
						}
					}
				}
				if (check)
					break;
			}
			System.out.println();
			if (check) {
				answer[idx] = 0;
			} else {
				answer[idx] = 1;
			}
		}
		return answer;
	}

	public static boolean bfs(int idx, String[][] places) {
		int cnt = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();
			if (cnt == 2)
				return false;
			for (int i = 0; i < size; i++) {
				Node cur = Q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if (nx < 0 || nx >= len || ny < 0 || ny >= len || visit[nx][ny]
							|| places[idx][nx].charAt(ny) == 'X')
						continue;
					if (places[idx][nx].charAt(ny) == 'P')
						return true;
					Q.add(new Node(nx, ny));
					visit[nx][ny] = true;
				}
			}
			cnt++;
		}
		return false;
	}

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
