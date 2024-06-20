import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		//1개 또는 3개 가져갈 수 있음
		if(N%2==0)
		{
			System.out.println("CY");
		}
		else
		{
			System.out.println("SK");
		}
	}
}
