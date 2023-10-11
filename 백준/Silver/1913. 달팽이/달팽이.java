import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		int []dx = {0,1,0,-1}; // 하우상좌
		int []dy = {1,0,-1,0}; // 하우상좌

		int x=0;
		int y=-1;
		int cnt=N*N;
		int dir = 0;
		while(cnt>0)
		{
			int nexty=y+dy[dir];
			int nextx=x+dx[dir];
			if(nexty<0||nextx<0||nexty>=N||nextx>=N||arr[nexty][nextx]!=0)
			{
				dir=(dir==3)?0:dir+1; 
				nexty=y+dy[dir];
				nextx=x+dx[dir];
			}
			y=nexty;
			x=nextx;
			arr[nexty][nextx]=cnt;
			//System.out.println(nexty+" "+nextx+" "+cnt);
			cnt--;
		}
		
		int ansy=0;
		int ansx=0;
		/*
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.printf("%5d",arr[i][j]);
				//System.out.print(arr[i][j]+" ");
				if(arr[i][j]==P)
				{
					ansy=i;
					ansx=j;
				}
			}
			System.out.println();
		}
		System.out.println((ansy+1)+" "+(ansx+1));
		*/
        
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				sb.append(arr[i][j]+" ");
				if(arr[i][j]==P)
				{
					ansy=i;
					ansx=j;
				}
			}
			sb.append("\n");
		}
		sb.append((ansy+1)+" "+(ansx+1));
		System.out.println(sb.toString());
	}
}
