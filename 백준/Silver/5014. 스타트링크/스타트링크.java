import java.io.*;
import java.util.*;

public class Main {

	public static int[] arr;
	public static int ans;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr=new int[5];
		for(int i=0;i<5;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		ans=Integer.MAX_VALUE;
		boolean[] visited=new boolean[arr[0]+1];
		
		//bfs
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int[] {arr[1],0});
		while(!q.isEmpty())
		{
			int tmp[]=q.poll();
			if(tmp[0]==arr[2])
			{
				ans=Math.min(ans,tmp[1]);
				break;
			}
			
			if(tmp[0]+arr[3]<=arr[0])
			{
				if(!visited[tmp[0]+arr[3]])
				{
					visited[tmp[0]+arr[3]]=true;
					q.offer(new int[] {tmp[0]+arr[3],tmp[1]+1});
				}
			}
			if(tmp[0]-arr[4]>0)
			{
				if(!visited[tmp[0]-arr[4]])
				{
					visited[tmp[0]-arr[4]]=true;
					q.offer(new int[] {tmp[0]-arr[4],tmp[1]+1});
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		if(ans==Integer.MAX_VALUE)
		{
			sb.append("use the stairs");
		}
		else
		{
			sb.append(ans);
		}
		System.out.println(sb.toString());
	}
}