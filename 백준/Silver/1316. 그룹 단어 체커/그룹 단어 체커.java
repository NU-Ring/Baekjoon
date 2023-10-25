import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws Exception {
		//System.setIn(new FileInputStream("res/input_실버5_1316_그룹단어체커"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int ans=0;
		for(int i=0;i<N;i++)
		{
			char[] word = br.readLine().toCharArray();
			boolean[]visited=new boolean[26];
			int tmp=0;
			boolean flag=false;
			for(int j=0;j<word.length;j++)
			{
				if(visited[word[j]-'a']!=true)//처음나온 알파벳
				{
					tmp=word[j]-'a';
					visited[word[j]-'a']=true;
				}
				else
				{
					if(tmp!=word[j]-'a')
					{
						flag=true;
						j=word.length;
					}
					else
					{
						visited[word[j]-'a']=true;
					}
				}
			}
			if(flag!=true)
			{
				ans++;
			}
		}
		System.out.println(ans);
	}
}
