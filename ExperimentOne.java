package ExperimentOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class cmp implements Comparator<Vexture>{

	@Override
	public int compare(Vexture o1, Vexture o2) {
		// TODO Auto-generated method stub
		return o1.weight-o2.weight;
	}
		
}

class Vexture{
	public int start;		//边的起点
	public int end;		//终点
	public int weight;		//权值
	
}

class Graph {
	public static final int MAXVEX = 4;
	public static final int INF = 65535;
//	public static int[][] graph = new int[][] {
//		{INF,6,1,5,INF,INF},
//		{6,INF,5,INF,3,INF},
//		{1,5,INF,5,6,4},
//		{5,INF,5,INF,INF,2},
//		{INF,3,6,INF,INF,6},
//		{INF,INF,4,2,6,INF}
//	};
	public static int[][] graph=new int[][] {
		{INF,1,5,1},
		{1,INF,6,3},
		{5,6,INF,2},
		{1,3,2,INF}
	};
	
	//prim算法
	public int prim(int start) {
		int []lowcost=new int[MAXVEX];
		int []adjvex=new int[MAXVEX];
		lowcost[start]=0;
		adjvex[start]=0;
		int i,j,k,m,n,min,index;
		index=0;
		adjvex[index++]=start;
		for(i=0;i<MAXVEX;i++){
			lowcost[i]=graph[start][i];
		}
		
		lowcost[start]=0;

		for(i=0;i<MAXVEX;i++){
			if(i==start){
				continue;
			}

			min=INF;
			k=0;
			for(j=0;j<MAXVEX;j++){
				if(lowcost[j]!=0&&lowcost[j]<min){
					min=lowcost[j];
					k=j;
				}
			}

			adjvex[index++]=k;	//表示将该点收录点集合
			lowcost[k]=0;

			for(j=1;j<MAXVEX;j++){
				if(lowcost[j]!=0&&graph[k][j]<lowcost[j]){
					lowcost[j]=graph[k][j];
				}
			}
		}

		int sum=0;
		for(i=1;i<index;i++){
			min=INF;
			m=adjvex[i];
			for(j=0;j<i;j++){
				n=adjvex[j];
				if(graph[n][m]<min){
					min=graph[n][m];
				}
			}
			sum+=min;
		}
		return sum;
	}
	
	//判断两者是否在同一集合
		public int find(int x,int father[]) {
			if(x!=father[x]) {
				x=find(father[x],father);
			}
			return x;
		}
	
	//kruskal算法
	public int kruskal(int start) {
		cmp cmp=new cmp();
		ArrayList<Vexture> vex=new ArrayList<Vexture>();
		int index=0;
		for(int i=0;i<MAXVEX;i++) {
			for(int j=i+1;j<MAXVEX;j++) {
				if(graph[i][j]!=INF) {
					Vexture vexDemo=new Vexture();
					vexDemo.start=i;
					vexDemo.end=j;
					vexDemo.weight=graph[i][j];
					vex.add(vexDemo);
					index++;
				}
			}
		}
		Collections.sort(vex, cmp);	//按边的权值排序
		int min=0,sum=0;
		int[] father=new int[MAXVEX];
		//将所有节点的父节点设置为自己
		for (int i = 0; i < MAXVEX; i++) {
			father[i]=i;
		}
		int k=0;
		for(int i=0;i<index;i++) {
			Vexture e=vex.get(i);
			int father1=find(e.start,father);
			int father2=find(e.end,father);
			if(father1!=father2) {
				sum+=e.weight;
				k++;
				father[father1]=father2;
			}
			if(k==MAXVEX-1) {
				break;		//如果收入了所有点则跳出循环
			}
		}
		return sum;
	}
}

public class ExperimentOne {
	public static void main(String[] args) {
		Graph p=new Graph();
		int primResult=p.prim(0);
		int kruskalResult=p.kruskal(0);
		System.out.println(primResult);
		System.out.println(kruskalResult);
	}
}
