import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[][] check;
	static int maxHeight = Integer.MIN_VALUE;
	static int[] dx = new int[] {-1,0,1,0};
	static int[] dy = new int[] {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n][n];
		
		//i가 y다. j가 x다.
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > maxHeight) maxHeight = arr[i][j];
			}
		}
	
		
		int maxCount = Integer.MIN_VALUE;
		
		//h가 1일때부터 maxHeight보다 작을때까지 확인
		for(int h=0; h<maxHeight; h++) {
			check = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]<=h) {
						check[i][j] = true;
					}
				}
			}
			int count = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!check[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			if(count > maxCount) maxCount = count;
		}
		System.out.print(maxCount);
	}
	
	public static void dfs(int y, int x) {
		check[y][x] = true;
		
		for(int i=0; i<4; i++) {
			if(y+dy[i]>=0 && x+dx[i]>=0 && y+dy[i]<n && x+dx[i]<n && !check[y+dy[i]][x+dx[i]]) {
				dfs(y+dy[i],x+dx[i]);
			}
		}
	}
}
