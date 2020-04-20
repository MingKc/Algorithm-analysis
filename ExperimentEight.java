package Experiment;

public class ExperimentEight {
	//最小运算次数	
	private static int[][] m=new int[6][6];
	//最后一次运算记录	
	private static int[][] s=new int[6][6];
	public static void main(String[] args) {
		int[] P= {20,15,10,3,5,25};
		int n=5;
		MatrixChain(P,n);
		System.out.println("最小运算次数为："+m[1][5]);
	}
	
	public static void MatrixChain(int[] arr,int n) {
		//r为当前问题规模
		int j=0;
		for (int r = 2; r <= n; r++) {
			//i表示不同的起点
			for (int i = 1; i <= n-r+1; i++) {
				//j表示不同的终点
				j=i+r-1;
				m[i][j]=m[i+1][j]+arr[i-1]*arr[i]*arr[j];
				s[i][j]=i;
				for (int k = i+1; k <=j-1; k++) {
					int t=m[i][k]+m[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(t<m[i][j]) {
						m[i][j]=t;
						s[i][j]=k;
					}
				}
			}
		}
	}
}
