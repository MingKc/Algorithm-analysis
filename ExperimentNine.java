package Experiment;

import java.util.LinkedList;

public class ExperimentNine {
	//序列X
	private static final char[] X= {'A','B','D','C','B','A','C'};
	//序列Y
	private static final char[] Y= {'B','C','A','D','A','A'};
	//记录每个最长子串的长度	
	private static int[][] C=new int[X.length+1][Y.length+1];
	//记录每次选择的操作
	private static String[][] B=new String[X.length+1][Y.length+1];
	//记录最长公共子序列
	private static LinkedList<Character>list=new LinkedList<Character>();
	public static void main(String[] args) {
		findMaxLength();
		maxSubsequence(X.length, Y.length);
		System.out.println("X和Y的最长公共子序列是："+list);
	}
	//找到最长公共子串的长度
	public static void findMaxLength() {
		//初始化C[i,j]
		for (int i = 0; i < X.length; i++) {
			C[i][0]=0;
		}
		for (int i = 0; i < Y.length; i++) {
			C[0][i]=0;
		}
		// i 问题的规模（长度）
		for (int i = 1; i <= X.length; i++) {
			// j的值不断变化
			for (int j = 1; j <= Y.length; j++) {
				//X和Y的初始下标为0
				if(X[i-1]==Y[j-1]) {
					C[i][j]=C[i-1][j-1]+1;
					B[i][j]="删除x和y";
				}else {
					if(C[i][j-1]>C[i-1][j]) {
						C[i][j]=C[i][j-1];
						B[i][j]="删除y";
					}else {
						C[i][j]=C[i-1][j];
						B[i][j]="删除x";
					}
				}
			}
		}
	}
	
	//输出最长公共子序列
	public static void maxSubsequence(int i,int j) {
		if(i==0||j==0) {
			return ;
		}
		if("删除x和y".equals(B[i][j])) {
			list.add(X[i-1]);
			i--;
			j--;
		}else if("删除x".equals(B[i][j])){
			i--;
		}else if("删除y".equals(B[i][j])) {
			j--;
		}
		maxSubsequence(i, j);
	}
}
