import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int ans=0;
		//3kg , 5kg봉지
		while(N>0)
		{
			if(N%5==0)
			{
				ans+=N/5;
				break;
			}
			N-=3;
			ans++;
			if(N<0)
			{
				ans=-1;
				break;
			}
		}
		System.out.println(ans);
	
	}

}