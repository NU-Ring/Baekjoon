import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_실버1_13335_트럭"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()); //트럭의 개수 4
 		int W=Integer.parseInt(st.nextToken()); // 다리 길이 2
		int L=Integer.parseInt(st.nextToken()); // 최대 하중 10
		
		st=new StringTokenizer(br.readLine());
		Queue <Integer> q = new LinkedList<>();
		for(int i=0;i<N;i++)
		{
			int tmp=Integer.parseInt(st.nextToken());
			q.offer(tmp);
		}
		Queue<Integer>bridge = new LinkedList<>();
		for(int i=0;i<W;i++)
		{
			bridge.offer(0);
		} // 현재 다리 전체에 아무것도 없기떄문에 무게 0롤 채워준다.
		int ans=0;
		int weight=0;
		
		while(!bridge.isEmpty())
		{
			ans++; // 1초 경과
			weight-=bridge.poll(); //젤트럭을 한칸씩 잡아 당김
			if(!q.isEmpty()) // 지나가지 못한 트럭이 있고
			{
				if(q.peek()+weight<=L)//현재 다리 위의 트럭 무게 + 못지나간 다음 트럭 무게가 하중보다 작으면
				{
					int nxtweight = q.poll();
					weight+=nxtweight;
					bridge.offer(nxtweight);
				}
				else // 못지나간 다음 트럭이 무거워 못올라가면
				{
					bridge.offer(0); // 빈공간으로 둔다 
				}
			}
		}
		System.out.println(ans);
	}

}
