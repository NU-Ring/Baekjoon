import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input_실버2_1138_한줄로서기"));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=N;i>=1;i--)
		{
			list.add(arr[i],i);
		}
		for(int i:list)
		{System.out.print(i+" ");}
	}
}
