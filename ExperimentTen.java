package Experiment;

public class ExperimentTen {
	//����
	private static final int[] m= {1,2,3,4,5,6,7,8,9,10};
	//���ʼʱ��
	private static final int[] s= {1,3,2,5,4,5,6,8,8,2};
	//���ֹʱ��
	private static final int[] f= {4,5,6,7,9,9,10,11,12,13};
	//�ռ��ʱ��
	private static final int[] p= {3,2,4,2,5,4,4,3,4,11};
	public static void main(String[] args) {
		occupyGreed();
		System.out.println();
		startGreed();
	}
	
	//�����ʼʱ������
	public static void startGreed() {
		for (int i = 0; i < s.length-1; i++) {
			for (int j = 0; j < s.length-i-1; j++) {
				if(s[j]>s[j+1]) {
					int temp=s[j+1];
					int temp2=f[j+1];
					int temp3=m[j+1];
					s[j+1]=s[j];
					f[j+1]=f[j];
					m[j+1]=m[j];
					s[j]=temp;
					f[j]=temp2;
					m[j]=temp3;
				}
			}
		}
		
		int[] A=new int[10];
		A[0]=m[0];
		int x=1;
		int j=0;
		for (int i = 1; i < s.length; i++) {
			if(s[i]>=f[j]) {
				A[x++]=m[i];
				j=i;
			}
		}
		System.out.print("�Կ�ʼʱ������");
		for (int i = 0; i < x; i++) {
			System.out.print("ѡ��"+A[i]);
			if(i!=x-1) {
				System.out.print(",");
			}
		}
	}
	
	//��ÿ���ʱ���ռ��ʱ���С��������
	public static void occupyGreed() {
		for (int i = 0; i < s.length-1; i++) {
			for (int j = 0; j < s.length-i-1; j++) {
				if(p[j]>p[j+1]) {
					int temp=s[j+1];
					int temp2=f[j+1];
					int temp3=m[j+1];
					int temp4=p[j+1];
					s[j+1]=s[j];
					f[j+1]=f[j];
					m[j+1]=m[j];
					p[j+1]=p[j];
					s[j]=temp;
					f[j]=temp2;
					m[j]=temp3;
					p[j]=temp4;
				}
			}
		}
		int[] A=new int[10];
		A[0]=m[0];
		int x=1;
		int j=0;
		for (int i = 1; i < s.length; i++) {
			if(s[i]>=f[j]) {
				A[x++]=m[i];
				j=i;
			}
		}
		System.out.print("��ռ��ʱ������");
		for (int i = 0; i < x; i++) {
			System.out.print("ѡ��"+A[i]);
			if(i!=x-1) {
				System.out.print(",");
			}
		}
	}
}
