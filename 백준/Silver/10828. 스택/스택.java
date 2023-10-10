import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int tmp=0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			String order = st.nextToken();
			//System.out.println(order);
			if(order.equals("push"))
			{
				tmp=Integer.parseInt(st.nextToken());
				stack.push(tmp);
			}
			else if(order.equals("pop"))
			{
				if(stack.isEmpty())
				{
					System.out.println(-1);
				}
				else
				{
					tmp=stack.pop();
					System.out.println(tmp);
				}
			}
			else if(order.equals("size"))
			{
				System.out.println(stack.size());
			}
			else if(order.equals("empty"))
			{
				if(stack.isEmpty())
				{
					System.out.println(1);
				}
				else
				{
					System.out.println(0);
				}
				
			}
			else// if(order=="top")
			{
				if(stack.isEmpty())
				{
					System.out.println(-1);
				}
				else
				{
					tmp=stack.peek();
					System.out.println(tmp);
				}
			}
		}
	}
}
