import java.util.*;
import java.io.*;

public class Main {

	public static int M;//상자 가로 칸의 수
	public static int N;//상자 세로 칸의 수
	public static int[][]arr;
	public static int[]dy= {-1,1,0,0}; //상 하 좌 우
	public static int[]dx= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		/*입력값 입력*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		int cnt=0;
		Queue<int[]>q= new LinkedList<>();
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				// 1: 익은            0:익지않은         -1:빈
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)
				{
					q.offer(new int[] {i,j});
				}
				else if(arr[i][j]==0)
				{
					cnt++;
				}
			}
		}
		
		int date=0;

		while(!q.isEmpty()&&cnt>0)
		{
			int size=q.size();
			for(int i=0;i<size;i++)
			{
				int tmp[]=q.poll();
				for(int d=0;d<4;d++)
				{
					int ny=tmp[0]+dy[d];
					int nx=tmp[1]+dx[d];
					if(ny>=0&&nx>=0&&ny<N&&nx<M)
					{
						if(arr[ny][nx]==0)
						{
							arr[ny][nx]=1;
							q.offer(new int[] {ny,nx});
							cnt--;
						}
					}
				}
			}
			date++;
		}
		
		
		if(cnt!=0) // 덜익은 토마토가 있을 시 -1출력
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(date);
		}
	}
}