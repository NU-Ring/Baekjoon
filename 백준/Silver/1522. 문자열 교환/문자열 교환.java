import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input_실버1_1522_문자열"));
		char[] arr = br.readLine().toCharArray();
		int cntA=0; // a문자열의 개수를 카운트
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]=='a')
			{
				cntA++;
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) // 원형으로 생각, a의 개수만큼 슬라이딩윈도우 형식으로 돌며 사이의 a가 아닌 문자 체크(해당 개수=교환 개수)
		{
			int cntChange=0;
			for(int j=0;j<cntA;j++)
			{
				int ij=i+j;
				if(ij>=arr.length)
				{
					ij-=arr.length;
				}
				if(arr[ij]!='a')
				{
					cntChange++;
				}
			}
			ans=Math.min(ans,cntChange);
		}
		System.out.println(ans);
	}
}
