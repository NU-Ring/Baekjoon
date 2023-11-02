import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int cost;
		public Node(int y, int x, int cost)
		{
			this.y=y;
			this.x=x;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node n) {
			return cost-n.cost;
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input_골드4_4485_녹색옷을입은애가젤다지"));
		int tc=0;
		while(true)
		{
			tc++;
			int N=Integer.parseInt(br.readLine());
			if(N==0)
			{
				return;
			}
			int arr[][]=new int[N][N];
			StringTokenizer st;
			for(int i=0;i<N;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int dy[]= {-1,1,0,0};
			int dx[]= {0,0,-1,1};
			int cost[][]=new int[N][N];
			boolean visited[][]=new boolean[N][N];
			PriorityQueue<Node>pq=new PriorityQueue<>();
			pq.offer(new Node(0,0,arr[0][0]));
			visited[0][0]=true;
			cost[0][0]=arr[0][0];
			while(!pq.isEmpty())
			{
				Node now=pq.poll();
				for(int i=0;i<4;i++)
				{
					int ny=now.y+dy[i];
					int nx=now.x+dx[i];
					if(ny>=0&&nx>=0&&ny<N&&nx<N)
					{
						if(visited[ny][nx]==false)
						{
							int nc=now.cost+arr[ny][nx];
							cost[ny][nx]=nc;
							visited[ny][nx]=true;
							pq.offer(new Node(ny,nx,nc));
						
						}
					}
				}
			}
			System.out.printf("Problem %d: %d\n",tc,cost[N-1][N-1]);	
		}
	}
}