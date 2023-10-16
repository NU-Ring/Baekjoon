import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int arr[][];
	public static int visited[][];
	public static int ans;
	public static int[] dy= {-1,1,0,0};
	public static int[] dx= {0,0,-1,1};
	
	
	public static void bfs(int y,int x, int h,int cnt)
	{
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y,x});
		visited[y][x]=cnt;
		
		while(!q.isEmpty())		{
			int[] tmp = q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=tmp[0]+dy[i];
				int nx=tmp[1]+dx[i];
				if(ny>=0&&nx>=0&&ny<N&&nx<N)
				{
					if(visited[ny][nx]==0 && arr[ny][nx]>h )
					{
						visited[ny][nx]=cnt;
						q.offer(new int[] {ny,nx});
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int low=Integer.MAX_VALUE;
		int high = 0;
		
		
		//입력값
		N=Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
				high=Math.max(high,arr[i][j]);
			}
		}
		
		//풀이
		ans=0;
		for(int k=0;k<=high;k++)
		{
			visited=new int [N][N];
			int cnt=0;
			//System.out.println("높이:"+k);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(arr[i][j]>k&&visited[i][j]==0)
					{
						cnt++;
						bfs(i,j,k,cnt);
					}
				}
			}
			ans=Math.max(ans,cnt);
			
			////디버그
			/*
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					System.out.print(visited[i][j]+" ");
				}System.out.println();
			}
			System.out.println();
			*/
			
		}
		sb.append(ans);
		System.out.println(ans);
	}

}
