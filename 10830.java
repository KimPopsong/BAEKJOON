import java.io.*;
import java.util.*;

public class Main {
	static int matrixSize; // 행렬의 크기
	static long exponent; // 지수의 크기
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		matrixSize = Integer.parseInt(st.nextToken());
		exponent = Long.parseLong(st.nextToken());

		matrix = new int[matrixSize][matrixSize]; // 행렬 입력
		for (int r = 0; r < matrixSize; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < matrixSize; c++) {
				matrix[r][c] = Integer.parseInt(st.nextToken()) % 1000; // 입력시 1000이 입력될 수 있음
			}
		}

		int[][] result = calcNSquare(matrix, exponent);

		for (int r = 0; r < matrixSize; r++) {
			for (int c = 0; c < matrixSize; c++) {
				System.out.print(result[r][c] + " ");
			}
			System.out.println();
		}
	}

	static int[][] calcNSquare(int[][] tempMatrix, long e) { // 행렬의 e 제곱 구하기
		int[][] tMatrix = new int[matrixSize][matrixSize]; // 매트릭스 행렬 복사
		for (int r = 0; r < matrixSize; r++) {
			for (int c = 0; c < matrixSize; c++) {
				tMatrix[r][c] = tempMatrix[r][c];
			}
		}

		if (e == 1) { // 지수가 1일시 그대로 반환
			return tMatrix;
		}

		else if (e == 2) {
			return squareMatrix(tempMatrix);
		}

		else if (e % 2 == 1) { // 지수가 홀수일 경우
			return multiplyMatrix(squareMatrix((calcNSquare(tempMatrix, e / 2L))), tempMatrix);
		}

		else { // 지수가 짝수일 경우
			return squareMatrix((calcNSquare(tempMatrix, e / 2L)));
		}
	}

	static int[][] squareMatrix(int[][] tempMatrix) { // 행렬 제곱
		int[][] returnMatrix = new int[matrixSize][matrixSize]; // 반환할 행렬

		for (int r = 0; r < matrixSize; r++) {
			for (int c = 0; c < matrixSize; c++) {
				int sum = 0;

				for (int n = 0; n < matrixSize; n++) {
					sum += tempMatrix[r][n] * tempMatrix[n][c];
				}

				returnMatrix[r][c] = sum % 1000;
			}
		}

		return returnMatrix;
	}

	static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) { // 행렬 곱
		int[][] returnMatrix = new int[matrixSize][matrixSize]; // 반환할 행렬

		for (int r = 0; r < matrixSize; r++) {
			for (int c = 0; c < matrixSize; c++) {
				int sum = 0;

				for (int n = 0; n < matrixSize; n++) {
					sum += matrix1[r][n] * matrix2[n][c];
				}

				returnMatrix[r][c] = sum % 1000;
			}
		}

		return returnMatrix;
	}
}
