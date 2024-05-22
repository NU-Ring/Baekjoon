import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int tc=0;tc<TC;tc++)
		{
			boolean flag=false;
			int n=Integer.parseInt(br.readLine());
			int arr[][]=new int[n+2][2];
			Queue<int[]>q = new LinkedList<int[]>();
			for(int i=0;i<n+2;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0]=Integer.parseInt(st.nextToken()); // x좌표
				arr[i][1]=Integer.parseInt(st.nextToken()); // y좌표
			}
			boolean visited[]=new boolean[n+2];
			q.offer(new int[] {arr[0][0],arr[0][1]});
			visited[0]=true;
			
			while(!q.isEmpty())
			{
				int[]tmp = q.poll();
				//System.out.println(tmp[0]+" "+tmp[1]+" 방문");
				for(int i=1;i<n+2;i++)
				{
					if(visited[i]==true)
					{
						continue;
					}
					//System.out.println(Math.abs(tmp[0]-arr[i][0])+Math.abs(tmp[1]-arr[i][1])+" "+ i);
					if(Math.abs(tmp[0]-arr[i][0])+Math.abs(tmp[1]-arr[i][1])<=1000)
					{
						if(i==n+1)
						{
							flag=true;
							q.clear();
							break;
						}
						visited[i]=true;
						q.offer(new int[] {arr[i][0],arr[i][1]});
					}
				}
			}
			if(flag==true)
			{
				System.out.println("happy");
			}
			else
			{
				System.out.println("sad");
			}
			//한 박스 = 20개, 편의점 도착 시 빈 병을 새 병으로 교체 가능. 50m에 한 병씩 마심
			//거리의 거리 = x좌표차+y좌표차	
		}
	}

}
