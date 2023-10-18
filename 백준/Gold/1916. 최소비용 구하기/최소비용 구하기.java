import java.util.*;
import java.io.*;

public class Main {

	static class Node implements Comparable<Node>
	{
		int v;
		int cost;
		
		public Node(int v, int cost){
			this.v=v;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node node)
		{
			return this.cost-node.cost;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1916_골드5_최소비용구하기"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine()); // 도시의 개수 (1 ≤ N ≤ 1,000)
		int M=Integer.parseInt(br.readLine()); // 버스의 개수 (1 ≤ M ≤ 100,000)
		
		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<=N;i++)
		{
			list.add(new ArrayList<Node>());
		}
		
		StringTokenizer st;
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(start).add(new Node(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int ST = Integer.parseInt(st.nextToken());
		int ED = Integer.parseInt(st.nextToken());
		
		int ans[] = new int[N+1];
		Arrays.fill(ans,Integer.MAX_VALUE);
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(ST,0));
		ans[ST]=0;
		while(!pq.isEmpty())
		{
			Node now=pq.poll();
            if(ans[now.v]<now.cost)
            {
                continue;
            }
			for(Node next:list.get(now.v))
			{
				if(ans[next.v]>ans[now.v]+next.cost)
				{
					ans[next.v]=ans[now.v]+next.cost;
					pq.offer(new Node(next.v, ans[next.v]));
				}
			}
		}
		System.out.println(ans[ED]);
	}
}