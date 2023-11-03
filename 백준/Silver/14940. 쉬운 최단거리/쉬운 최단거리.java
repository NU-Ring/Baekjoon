import java.io.*;
import java.util.*;

public class Main{
	public static int Y;
	public static int X;
	public static int[][]arr;
	public static int end[];//도착지 좌표(y,x)
	
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int cost;
		
		public Node(int y,int x, int cost){
			this.y=y;
			this.x=x;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node n)
		{
			return cost-n.cost;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input_실버1_14940_쉬운최단거리"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		arr=new int [Y][X];
		end=new int[2];
		for(int i=0;i<Y;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<X;j++)
			{;
				//1은갈 수 있는 땅, 2는 목표지점, 0은 갈 수 없음
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==2)
				{
					end[0]=i;
					end[1]=j;
				}
			}
		}
		//입력값 받기 종료
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][]visited=new boolean[Y][X];
		pq.offer(new Node(end[0],end[1],0)); // 끝점부터 모든 칸까지의 거리 
		visited[end[0]][end[1]]=true;
		arr[end[0]][end[1]]=0;
		
		int dy[]= {-1,1,0,0}; //상하좌우 이동을 위한 배열
		int dx[]= {0,0,-1,1};
		
		while(!pq.isEmpty())
		{
			Node now=pq.poll();
			for(int i=0;i<4;i++)
			{
				int ny=now.y+dy[i];
				int nx=now.x+dx[i];
				if(ny>=0&&nx>=0&&ny<Y&&nx<X)//배열 범위를 벗어나지 않을 때만 이동
				{
					if(visited[ny][nx]!=true&&arr[ny][nx]==1) //방문하지 않았을 때만 방문(우선순위 큐이기때문에 제일 처음 방문한 값이 작기 때문)
					{
						visited[ny][nx]=true;
						int nc=now.cost+arr[ny][nx];
						arr[ny][nx]=nc;
						pq.offer(new Node(ny,nx,nc));
					}
				}
			}
		}
	
		visited=new boolean[Y][X]; //갈 수 있는 곳으로 표시되었지만 실질적으로 갈 수 없었던 곳 체크를 위한 
		for(int i=0;i<4;i++)
		{
			int ny=end[0]+dy[i];
			int nx=end[1]+dx[i];
			if(ny>=0&&nx>=0&&ny<Y&&nx<X)
			{
				visited[ny][nx]=true;
			}
		}
		
		for(int i=0;i<Y;i++)
		{
			for(int j=0;j<X;j++)
			{
				if(visited[i][j]==false&&arr[i][j]==1)
				{
					System.out.print(-1+" ");
				}
				else
				{
					System.out.print(arr[i][j]+" ");
				}
			}System.out.println();
		}
	}
}