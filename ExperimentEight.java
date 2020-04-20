package Experiment;

public class ExperimentEight {
	//��С�������	
	private static int[][] m=new int[6][6];
	//���һ�������¼	
	private static int[][] s=new int[6][6];
	public static void main(String[] args) {
		int[] P= {20,15,10,3,5,25};
		int n=5;
		MatrixChain(P,n);
		System.out.println("��С�������Ϊ��"+m[1][5]);
	}
	
	public static void MatrixChain(int[] arr,int n) {
		//rΪ��ǰ�����ģ
		int j=0;
		for (int r = 2; r <= n; r++) {
			//i��ʾ��ͬ�����
			for (int i = 1; i <= n-r+1; i++) {
				//j��ʾ��ͬ���յ�
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
