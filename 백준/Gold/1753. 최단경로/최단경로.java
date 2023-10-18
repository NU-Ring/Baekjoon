import java.util.*;
import java.io.*;

public class Main {

	static class Node implements Comparable<Node>{
		int v; // 정점의 번호
		int cost; // 정점의 가중치
		
		public Node(int v, int cost)
		{
			this.v=v;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node n)
		{
			// 작은 비용이 우선되도록
			return this.cost - n.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1753_골드4_최단경로"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 1 ≤ V ≤ 20,000      정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 1 ≤ E ≤ 300,000    간선의 개수
		// 20,000 * 300,000 개로 배열 생성 시 메모리 초과
		
		int ST = Integer.parseInt(br.readLine()); // 시작 정점
		
		//ArrayList 생성
		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<=V;i++)
		{
			list.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<E;i++)
		{
			st= new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());		
			int w=Integer.parseInt(st.nextToken());
			list.get(v1).add(new Node(v2, w));
		}
		
		//각 정점까지의 최소값을 저장하기 위한 배열
		int ans[] = new int[V+1]; 
		for(int i=0;i<V+1;i++)
		{
			ans[i]=Integer.MAX_VALUE;
		}
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(ST,0));
        ans[ST]=0;
		while(!pq.isEmpty())
		{
			Node now = pq.poll();
			for(Node next:list.get(now.v))
			{
				if(ans[next.v]>ans[now.v]+next.cost) // 다음걸 거쳐서 가는게 더욱 빠를 경우만 진행
				{
					ans[next.v]=ans[now.v]+next.cost;
					pq.add(new Node(next.v,ans[next.v]));
				}
			}
		}
		
		for(int i=1;i<=V;i++)
		{
			if(ans[i]==Integer.MAX_VALUE)
			{
				System.out.println("INF");
			}
			else
			{
				System.out.println(ans[i]);
			}
		}
	}
}