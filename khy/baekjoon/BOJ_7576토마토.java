package problem;

import java.io.*;
import java.util.*;

public class 토마토 {
	
	//x의수 , y의수
	static int m,n;

	//토마토의 상태를 담을 배열
	static int[][] arr;
	
	//익은 토마토를 담을 Queue
	static Queue<Tomato> que = new LinkedList<>();
	
	static int[] dx = new int[] {-1,0,1,0};
	static int[] dy = new int[] {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] strTemp = br.readLine().split(" ");
		m = Integer.parseInt(strTemp[0]);
		n = Integer.parseInt(strTemp[1]);
		
		arr = new int[n][m];
		//y
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			//x
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					//que에 다 담는다.
					que.offer(new Tomato(i,j));
				}
			}
		}
		
		while(!que.isEmpty()) {
			Tomato temp = que.poll();
			
			for(int i=0; i<4; i++) {
				if(temp.y+dy[i]>=0 && temp.x+dx[i]>=0 && temp.y+dy[i]<n && temp.x+dx[i]<m && arr[temp.y+dy[i]][temp.x+dx[i]] == 0) {
					arr[temp.y+dy[i]][temp.x+dx[i]] = arr[temp.y][temp.x] + 1;
					que.offer(new Tomato(temp.y+dy[i],temp.x+dx[i]));
				}
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m ; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
				}
				
				
				if(arr[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(max-1);
		
	}
}

class Tomato{
	int y;
	int x;
	
	Tomato(int y, int x){
		this.y = y;
		this.x = x;
	}
}