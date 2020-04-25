package Experiment;

import java.util.LinkedList;

public class ExperimentNine {
	//����X
	private static final char[] X= {'A','B','D','C','B','A','C'};
	//����Y
	private static final char[] Y= {'B','C','A','D','A','A'};
	//��¼ÿ����Ӵ��ĳ���	
	private static int[][] C=new int[X.length+1][Y.length+1];
	//��¼ÿ��ѡ��Ĳ���
	private static String[][] B=new String[X.length+1][Y.length+1];
	//��¼�����������
	private static LinkedList<Character>list=new LinkedList<Character>();
	public static void main(String[] args) {
		findMaxLength();
		maxSubsequence(X.length, Y.length);
		System.out.println("X��Y��������������ǣ�"+list);
	}
	//�ҵ�������Ӵ��ĳ���
	public static void findMaxLength() {
		//��ʼ��C[i,j]
		for (int i = 0; i < X.length; i++) {
			C[i][0]=0;
		}
		for (int i = 0; i < Y.length; i++) {
			C[0][i]=0;
		}
		// i ����Ĺ�ģ�����ȣ�
		for (int i = 1; i <= X.length; i++) {
			// j��ֵ���ϱ仯
			for (int j = 1; j <= Y.length; j++) {
				//X��Y�ĳ�ʼ�±�Ϊ0
				if(X[i-1]==Y[j-1]) {
					C[i][j]=C[i-1][j-1]+1;
					B[i][j]="ɾ��x��y";
				}else {
					if(C[i][j-1]>C[i-1][j]) {
						C[i][j]=C[i][j-1];
						B[i][j]="ɾ��y";
					}else {
						C[i][j]=C[i-1][j];
						B[i][j]="ɾ��x";
					}
				}
			}
		}
	}
	
	//��������������
	public static void maxSubsequence(int i,int j) {
		if(i==0||j==0) {
			return ;
		}
		if("ɾ��x��y".equals(B[i][j])) {
			list.add(X[i-1]);
			i--;
			j--;
		}else if("ɾ��x".equals(B[i][j])){
			i--;
		}else if("ɾ��y".equals(B[i][j])) {
			j--;
		}
		maxSubsequence(i, j);
	}
}
