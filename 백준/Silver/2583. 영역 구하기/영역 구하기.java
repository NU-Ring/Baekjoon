import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input_실버1_2583_영역구하기"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());// 100 이하의 자연수, 세로
		int N=Integer.parseInt(st.nextToken());// 100 이하의 자연수, 가로
		int K=Integer.parseInt(st.nextToken());// 100 이하의 자연수
		int[][] arr = new int [M][N];
		for(int k=0;k<K;k++)
		{
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			for(int i=y1;i<y2;i++)
			{
				for(int j=x1;j<x2;j++)
				{
					arr[i][j]=1;
				}
			}
		}
		//for debug
		/*
		for(int i=M-1;i>=0;i--)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		*/
		
		boolean visited[][]=new boolean[M][N];
		int cnt=0;
		LinkedList<Integer> list =new LinkedList<>();
		int[] dy= {-1,1,0,0};
		int[] dx= {0,0,-1,1};
		for(int i=M-1;i>=0;i--)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i][j]==0&&visited[i][j]==false)
				{
					cnt++;
					Queue<int[]>q=new LinkedList<>();
					q.offer(new int[] {i,j});
					visited[i][j]=true;
					int width=1;
					while(!q.isEmpty())
					{
						int[]tmp=q.poll();
						for(int d=0;d<4;d++)
						{
							int ny=tmp[0]+dy[d];
							int nx=tmp[1]+dx[d];
							if(ny>=0&&nx>=0&&ny<M&&nx<N)
							{
								if(arr[ny][nx]==0&&visited[ny][nx]==false)
								{
									q.offer(new int[] {ny,nx});
									visited[ny][nx]=true;
									width++;
								}
							}
						}
					}
					list.add(width);
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
	}
}