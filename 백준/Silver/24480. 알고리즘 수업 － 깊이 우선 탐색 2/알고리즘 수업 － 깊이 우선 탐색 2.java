import java.util.*;
import java.io.*;

public class Main {

	public static int N;//5 ≤ N ≤ 100,000
	public static int M;//1 ≤ M ≤ 200,000
	public static int R;//1 ≤ R ≤ N
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> list;
	public static int cnt;
	public static int[]ans;
	
	public static void DFS(int v)
	{
		if(visited[v]==false)
		{
			visited[v]=true;
			ans[v]=cnt;
			cnt++;
		}
		for(int i:list.get(v))
		{
			if(visited[i]==false)
			{
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*입력값 입력*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<>();
		for(int i=0;i<=N;i++)
		{
			list.add(new ArrayList<>());
		}

		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}
		
		//내림차순으로 방문(큰 수부터 방문)
		for(int i=1;i<list.size();i++)
		{
			Collections.sort(list.get(i),Collections.reverseOrder());
		}
		
		
		visited=new boolean[N+1];
		ans=new int[N+1];
		cnt=1;
		DFS(R);
		
		for(int i=1;i<=N;i++)
		{
			System.out.println(ans[i]);
		}
	}

}
