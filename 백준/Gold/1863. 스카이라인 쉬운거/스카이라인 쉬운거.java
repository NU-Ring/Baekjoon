import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int arr[][]=new int[n][2];
		int ans=0;
		Stack<Integer> stack =new Stack<>();
		StringTokenizer st;

		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());	
			
			/*
			 * 건물이 높이가 낮아질 때를 기준으로 count
			 * 건물의 높이가 낮아질 때 = 무조건 건물이 다름
			 * */

			//코딩 순서 ②
			while(!stack.isEmpty()&&stack.peek()>y)
			{
				stack.pop();
				ans++;
			}
			//코딩 순서 ③
			if(!stack.isEmpty()&&stack.peek()==y)
			{
				continue;
			}
			//코딩 순서①
			if(y!=0)
			{
				stack.push(y);
			}
		}
		ans+=stack.size();
		System.out.println(ans);
		
		/*
		 * 예제 입출력 
			10
			1 1
			2 2
			5 1
			6 3
			8 1
			11 0
			15 2
			17 3
			20 2
			22 1
			
			▼해당 예제를 그림으로 표현할 경우
			..........................
			.....XX.........XXX.......
			.XXX.XX.......XXXXXXX.....
			XXXXXXXXXX....XXXXXXXXXXXX
			
			 ▼ 답안
			..........................
			.....22.........333.......
			.111.22.......XX333XX.....
			X111X22XXX....XX333XXXXXXX
			
			..........................
			.....XX.........XXX.......
			.XXX.XX.......5555555.....
			4444444444....5555555XXXXX
			
			..........................
			.....XX.........XXX.......
			.XXX.XX.......XXXXXXX.....
			XXXXXXXXXX....666666666666
		 * */

	}
}