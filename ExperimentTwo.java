package Experiment;

public class ExperimentTwo {
	public final static int INF=65535;
	public static void main(String[] args) {
		int[][] graph1=new int[][]{
			{0,2,6,4},{INF,0,3,INF},{7,INF,0,1},{5,INF,12,0}
		};
		
		int[][] graph2=new int[][] {
			{0,1,INF,INF,INF,INF,INF,INF},
			{INF,0,INF,2,INF,INF,INF,INF},
			{2,INF,0,INF,INF,INF,INF,INF},
			{INF,INF,1,0,INF,8,INF,INF},
			{INF,INF,INF,2,0,INF,2,INF},
			{INF,INF,INF,INF,2,0,INF,INF},
			{INF,INF,INF,INF,INF,3,0,3},
			{INF,INF,INF,INF,INF,2,INF,0}
		};
		
		graph1=floyd(graph1);
		System.out.println("Floyd�㷨��");
		for (int i = 0; i < graph1.length; i++) {
			for (int j = 0; j < graph1.length; j++) {
				System.out.print(graph1[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Dijkstra�㷨��");
		int[] dist=dijkstra(graph2);
		for (int i = 1; i < dist.length; i++) {
			System.out.print(dist[i]+" ");
		}
		System.out.println("\n"+"����a������h����̾���Ϊ"+dist[7]);
	}
	
	//Floyd�㷨
	public static int[][] floyd(int[][] graph) {
		for(int k=0;k<graph.length;k++) {
			for(int i=0;i<graph.length;i++) {
				for(int j=0;j<graph.length;j++) {
					if(graph[i][j]>graph[i][k]+graph[k][j]) {
						graph[i][j]=graph[i][k]+graph[k][j];
					}
				}
			}
		}
		return graph;	
	}
	
	//�Ͻ���˹��
	public static int[] dijkstra(int[][] graph) {
		//�Ƿ���ʵ㼯
		int[] visit=new int[8];
		int[] dist=new int[8];
		
		//��ʼ����a�ĳ�ʼ·��
		for (int i = 1; i < dist.length; i++) {
			dist[i]=graph[0][i];
		}
		visit[0]=1;
		
		for(int i=1;i<dist.length;i++) {
			int min=INF,temp=0;
			for (int j = 1; j < dist.length; j++) {
				//����õ�δ����
				if(visit[j]!=1&&dist[j]<min) {
					min=dist[j];
					temp=j;
				}
			}
			visit[temp]=1;
			for (int j = 0; j < dist.length; j++) {
				if(graph[temp][j]+dist[temp]<dist[j]) {
					dist[j]=graph[temp][j]+dist[temp];
				}
			}
		}
		return dist;
	}
}
