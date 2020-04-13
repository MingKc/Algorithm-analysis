package Experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ExperimentSeven {
	public static void main(String[] args) {
		//项目总数为4
		int n=4;
		int money=5;
		int[][] arr=new int[][] {
			{0,0,0,0,0},
			{1,11,0,2,20},
			{2,12,5,10,21},
			{3,13,10,30,22},
			{4,14,15,32,23},
			{5,15,20,40,24}
		};
		dynamic(arr, n, money);
	}
	
	public static void dynamic(int[][] arr,int n,int money) {

		int[] gain=new int[10];
		int[] g=new int[10];
		int[][] a=new int[10][10];
		int[] t=new int[10];
		for (int i = 0; i <=money; i++) {
			g[i]=arr[i][1];
			a[1][i]=i;
		}
		for (int k = 2; k <= n; k++) {
			for (int i = 0; i <=money; i++) {
				t[i]=arr[i][k];
				a[k][i]=0;
			}
			for (int i = 0; i <= money; i++) {
				for (int j = 0; j <=i; j++) {
					if(arr[j][k]+g[i-j]>t[i]) {
						t[i]=arr[j][k]+g[i-j];
						a[k][i]=j;
					}
				}
			}
			for (int i = 0; i <=money; i++) {
				g[i]=t[i];
			}
		}
		int rest=money;
		for (int i = n; i>0;i--) {
			gain[i]=a[i][rest];
			rest-=gain[i];
		}
		for (int i = 1; i <=n; i++) {
			System.out.println("当第"+i+"个项目分配"+gain[i]+"万元");
		}
		System.out.println("最大收益为"+t[5]);
	}
}
