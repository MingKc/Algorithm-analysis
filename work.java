package Experiment;

public class work {
	//Բ�İ뾶������Բ�İ뾶�ĸ���+1����ʼ�±��1��ʼ
	private static int n = 4;
	
	//��СԲ���г���
	private static double length = 65535;
	
	//��¼Բ��Բ�ĺ�����
	private static double[] x = new double[n];
	
	//��¼��ʼ������Բ�İ뾶����
	private static double[] r = new double[n];
	
	//��¼��СԲ���г��ȵ����д���
	private static double[] bestr = new double[n];
	
	//����Բ��Բ���ھ����еĺ�����x
	public static double center(int k) {
		double temp = 0;
		//��t��Բ������Բ����������һ��Բ����
		for (int j = 1; j < k; j++) {
			//���ɶ���
			double index = x[j]+Math.sqrt(Math.pow((r[k]+r[j]), 2) - Math.pow((r[k]-r[j]), 2));
			//ÿ�����������м��㣬���ľ���Բ�ĺ�����
			if(index>temp) {
				temp = index;
			}
		}
		return temp;
	}
	
	//���㵱��Բ���г���
	public static void compute() {
		double low = 0,high = 0;
		for (int i = 0; i < n; i++) {
			//�ҳ�Բ��С���������
			if(x[i]-r[i]<low) {
				low = x[i]-r[i];
			}
			//�ҳ�Բ�����Ҳ�����
			if(x[i]+r[i]>high) {
				high = x[i]+r[i];
			}
		}
		//������СԲ���г���
		if(high - low <length) {
			length = high - low;
			for (int i = 0; i < n; i++) {
				bestr[i] = r[i];
			}
		}
	}
	//���ݷ�
	public static void search(int t) {
		//ֹͣ����
		if(t == n) {
			compute();
		}else {
			for (int i = t; i < n; i++) {
				swap(r, t, i);
				double centerx = center(t);
				//��ǰԲ���г���Ϊ��ǰԲ��Բ�ĺ�����+��Բ�İ뾶+��һ��Բ�İ뾶
				//�����ǰ����Բ���г���С��length�����������������ֱ�ӻ���
				if(centerx + r[t] + r[1] <length) {
					x[t] = centerx;
					search(t+1);
				}
				swap(r, t, i);
			}
		}
	}
	
	//����λ��
	public static void swap(double[] x,int i, int j) {
		double temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	
	public static void main(String[] args) {
		r[1]=1;
		r[2]=1;
		r[3]=2;
		search(1);
		System.out.println("����Բ���г���Ϊ��"+length);
		System.out.print("����Բ����˳���Ӧ�İ뾶�ֱ�Ϊ��");
		for (int i = 1; i < n; i++) {
			System.out.print(bestr[i]);
			if(i != n-1) {
				System.out.print(" , ");
			}
		}
	}
}
