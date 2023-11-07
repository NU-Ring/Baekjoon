import java.io.*;
import java.util.*;

public class Main {
	public static int Y;
	public static int X;
	public static int[][]arr;
	public static int[]dy= {-1,0,1,1,1,0,-1,-1};
	public static int[]dx= {-1,-1,-1,0,1,1,1,0};
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int dist;
		
		public Node(int y, int x, int dist)
		{
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
		
		@Override
		public int compareTo(Node n)
		{
			return this.dist-n.dist;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		arr=new int[Y][X];
		for(int i=0;i<Y;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<X;j++)
			{//0은 빈칸, 1은 아기상어
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}//입력값 입력 종료
		int ans=0;
		int safe[][]=new int[Y][X];
		for(int i=0;i<Y;i++)
		{
			for(int j=0;j<X;j++)
			{
				if(arr[i][j]!=1)
				{	//bfs 후 최소값을 safe[][]배열에 저장
					PriorityQueue<Node>pq=new PriorityQueue<>();
					boolean visited[][]=new boolean[Y][X];
					pq.offer(new Node (i,j,0));
					visited[i][j]=true;
					while(!pq.isEmpty())
					{
						Node tmp=pq.poll();
						for(int d=0;d<8;d++)
						{
							int ny=tmp.y+dy[d];
							int nx=tmp.x+dx[d];
							int nd=tmp.dist+1;
							if(ny>=0&&nx>=0&&ny<Y&&nx<X&&visited[ny][nx]==false)
							{
								if(arr[ny][nx]==1)
								{
									pq.clear();
									safe[i][j]=nd;
									ans=Math.max(ans,safe[i][j]);
									break;
								}
								else
								{
									visited[ny][nx]=true;
									pq.offer(new Node (ny,nx,nd));
								}
							}
							
						}
					}
					
				}
			}
		}
/*		for(int i=0;i<Y;i++)
		{
			for(int j=0;j<X;j++)
			{
				System.out.print(safe[i][j]+" ");
			}System.out.println();
		}*/
		System.out.println(ans);
	}
}