import java.io.*;
import java.util.*;

public class Main {
	
	static int x,y;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = new int[] {-1,0,1,0,-1,1,-1,1};
	static int[] dy = new int[] {0,1,0,-1,1,1,-1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(x == 0 && y ==0) break;
			
			arr = new int[y][x];
			check = new boolean[y][x];
			
			for(int i=0; i<y; i++) {
				 st = new StringTokenizer(br.readLine());
				 for(int j=0; j<x; j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
				 }
			}
			
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(!check[i][j] && arr[i][j] == 1) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int cy, int cx) {
		check[cy][cx] = true;
		
		for(int i=0; i<8; i++) {
			if(cy+dy[i]>=0 && cx+dx[i]>=0 && cy+dy[i]<y && cx+dx[i]<x && !check[cy+dy[i]][cx+dx[i]] && arr[cy+dy[i]][cx+dx[i]] == 1){
				dfs(cy+dy[i],cx+dx[i]);
			}
		}
		
	}
}
