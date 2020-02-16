@author Kshitij Porwal

/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
public static void main (String[] args)  throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//Scanner sc=new Scanner(System.in);
String w=br.readLine();
String[] w1=w.trim().split(" ");
int t=Integer.parseInt(w1[0]);

while(t-->0){
String c1=br.readLine();
String[] l1=c1.trim().split(" ");
int n=Integer.parseInt(l1[0]);
int q=Integer.parseInt(l1[1]);
HashMap<String,Integer> map=new HashMap<>();
 String h1=br.readLine();
 String[] h2=h1.trim().split(" ");
 int j=1;
 for(int i=0;i<h2.length;i++)
 {   
    map.put(h2[i],j++);
    
} 
int par[]=new int[j+1];
for(int i=1;i<=j;i++)
{
    par[i]=i;
}
int rank[]=new int[j+1];
Arrays.fill(rank,-1);
for(int i=0;i<q;i++){
    String z=br.readLine();
    String[] str=z.trim().split(" ");
    
    if(str[0].equals("arewefriends"))
    {
        if(find(map.get(str[1]),par)==find(map.get(str[2]),par)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    else{
     union(map.get(str[1]),map.get(str[2]),par,rank);
  }
     
    }
    
}
}

static void union(int a,int b,int par[],int rank[]){
    int x=find(a,par);
    int y=find(b,par);
    if(x==y) return ;
    if(rank[x]>rank[y]) par[y]=x;
    else if(rank[x]<rank[y]) par[x]=y;
    else{
        par[y]=x;
        rank[x]++;
    }
    
    
}



static int find(int x,int par[]){    
    if(par[x]==x)
    return x;
    else
    return find(par[x],par);
} 


}
