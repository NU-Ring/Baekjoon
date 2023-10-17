import java.util.*;
import java.io.*;

public class Main {
	
	public static int Y;
	public static int X;
	
	public static int ans;
	
	public static int[] dy= {-1,1,0,0}; // 상하좌우
	public static int[] dx= {0,0,-1,1};
	public static int arr[][];
	
	
	public static void comb(int cnt)
	{
		
		if(cnt==3)
		{
			ans=Math.max(ans,bfs());
			return;
		}
		

		for(int i=0;i<Y;i++)
		{
			for(int j=0;j<X;j++)
			{
				if(arr[i][j]==0)
				{
					arr[i][j]=1;
					comb(cnt+1);
					arr[i][j]=0;
				}
			}
		}
	}
	
	public static int bfs()
	{
		int cnt=Y*X;
		boolean visited[][] = new boolean[Y][X];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<Y;i++)
		{
			for(int j=0;j<X;j++)
			{
				if(arr[i][j]==2)
				{
					visited[i][j]=true;
					q.offer(new int[]{i,j});
					cnt--;
				}
				else if(arr[i][j]==1)
				{
					visited[i][j]=true;
					cnt--;
				}
			}
		}
		
		while(!q.isEmpty())
		{
			int[] tmp=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=tmp[0]+dy[i];
				int nx=tmp[1]+dx[i];
				if(ny>=0&&nx>=0&&ny<Y&&nx<X)
				{
					if(visited[ny][nx]==false&&arr[ny][nx]!=1)
					{
						cnt--;
						visited[ny][nx]=true;
						q.add(new int[] {ny,nx});
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_14502_골드4_연구소"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		//(3 ≤ N, M ≤ 8)
		Y =Integer.parseInt(st.nextToken()); //세로
		X =Integer.parseInt(st.nextToken()); //가로
		arr = new int[Y][X];
		
		//배열 받아오기
		//0:빈칸        1:벽          2:바이러스 위치
		for(int i=0;i<Y;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<X;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		ans=0;
		//nC3 으로 돌린 후 BFS로 바이러스 확인, 카운트하기
		comb(0);
	
		System.out.println(ans);

	}

}
