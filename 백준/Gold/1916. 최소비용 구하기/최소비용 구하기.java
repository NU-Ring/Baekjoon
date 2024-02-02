/*
* 작성자, 1.0, 2024.02.02 누Ring <dierdia@naver.com>
*
* BAEKJOON 골드5 1916 최소비용 구하기
* 문제 링크: https://www.acmicpc.net/problem/1916
* 작성 언어: JAVA
*/
import java.util.*;
import java.io.*;

public class Main{
	
    static class Node implements Comparable<Node>{
    	int v;
        int c;
        
        public Node(int v,int c){
        	this.v=v;
            this.c=c;
        }
        
        @Override
        public int compareTo(Node n){
        	return this.c-n.c;
        }
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list =new ArrayList<ArrayList<Node>>();
        for(int i=0;i<=N;i++){
        	list.add(new ArrayList<Node>());
        }
        
        for(int i=0;i<M;i++){
        	st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(n).add(new Node(v,c));
        }
        
        st=new StringTokenizer(br.readLine());
        int start= Integer.parseInt(st.nextToken());
        int end= Integer.parseInt(st.nextToken());
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        
        int[]ans = new int[N+1];
        for(int i=0;i<=N;i++)
	    {
        	ans[i]=Integer.MAX_VALUE;
        }
        
        ans[start]=0;
        while(!pq.isEmpty()){
        	Node now=pq.poll();
            //시간초과로 인해 아래 추가
			if(ans[now.v]<now.c)
			{
				continue;
			}
            for(Node next:list.get(now.v)){
            	if(ans[next.v]>ans[now.v]+next.c){
                	ans[next.v]=ans[now.v]+next.c;
                    pq.offer(new Node(next.v, ans[next.v]));
                }
            }
        }
        System.out.println(ans[end]);  
	}
}