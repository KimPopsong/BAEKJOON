#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct State {
	int r, c, jump;
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int canJump; // 말처럼 움직일 수 있는 횟수
	int colSize, rowSize;
	cin >> canJump >> colSize >> rowSize;

	vector<vector<int>> graph(rowSize, vector<int>(colSize)); // 그래프
	for (int i = 0; i < rowSize; ++i) {
		for (int j = 0; j < colSize; ++j) {
			cin >> graph[i][j];
		}
	}

	if (rowSize == 1 && colSize == 1) { // 사이즈가 1인 경우
		cout << 0 << '\n';
		return 0;
	}

	queue<State> bfs;
	vector<vector<int>> isVisit(rowSize, vector<int>(colSize, -1));

	bfs.push({ 0, 0, canJump });
	isVisit[0][0] = canJump;

	int dr[] = { -1, 1, 0, 0 };
	int dc[] = { 0, 0, 1, -1 };

	int dhr[] = { -2, -1, 1, 2, 2, 1, -1, -2 }; // 말처럼 움직이기
	int dhc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	int time = 0;

	while (!bfs.empty()) {
		int size = bfs.size();
		++time;

		for (int s = 0; s < size; ++s) {
			State curr = bfs.front();
			bfs.pop();

			// 걸어가기 (4 방향)
			for (int i = 0; i < 4; ++i) {
				int rr = curr.r + dr[i];
				int cc = curr.c + dc[i];

				if (rr >= 0 && rr < rowSize && cc >= 0 && cc < colSize) { // 범위 확인
					if (graph[rr][cc] != 1 && isVisit[rr][cc] < curr.jump) {
						bfs.push({ rr, cc, curr.jump });
						isVisit[rr][cc] = curr.jump;

						if (rr == rowSize - 1 && cc == colSize - 1) { // 도착
							cout << time << '\n';
							return 0;
						}
					}
				}
			}

			// 점프하기 (8 방향)
			if (curr.jump > 0) {
				for (int i = 0; i < 8; ++i) {
					int rr = curr.r + dhr[i];
					int cc = curr.c + dhc[i];

					if (rr >= 0 && rr < rowSize && cc >= 0 && cc < colSize) { // 범위 확인
						if (graph[rr][cc] != 1 && isVisit[rr][cc] < curr.jump - 1) {
							bfs.push({ rr, cc, curr.jump - 1 });
							isVisit[rr][cc] = curr.jump - 1;

							if (rr == rowSize - 1 && cc == colSize - 1) { // 도착
								cout << time << '\n';
								return 0;
							}
						}
					}
				}
			}
		}
	}

	cout << -1 << '\n'; // 도착할 수 없는 경우
	return 0;
}
