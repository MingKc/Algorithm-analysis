package Experiment;

public class work {
	//圆的半径序列中圆的半径的个数+1，起始下标从1开始
	private static int n = 4;
	
	//最小圆排列长度
	private static double length = 65535;
	
	//记录圆的圆心横坐标
	private static double[] x = new double[n];
	
	//记录初始给定的圆的半径序列
	private static double[] r = new double[n];
	
	//记录最小圆排列长度的排列次序
	private static double[] bestr = new double[n];
	
	//计算圆的圆心在矩形中的横坐标x
	public static double center(int k) {
		double temp = 0;
		//第t个圆可能与圆排列中任意一个圆相切
		for (int j = 1; j < k; j++) {
			//勾股定理
			double index = x[j]+Math.sqrt(Math.pow((r[k]+r[j]), 2) - Math.pow((r[k]-r[j]), 2));
			//每个都按照相切计算，最大的就是圆心横坐标
			if(index>temp) {
				temp = index;
			}
		}
		return temp;
	}
	
	//计算当期圆排列长度
	public static void compute() {
		double low = 0,high = 0;
		for (int i = 0; i < n; i++) {
			//找出圆最小的左侧坐标
			if(x[i]-r[i]<low) {
				low = x[i]-r[i];
			}
			//找出圆最大的右侧坐标
			if(x[i]+r[i]>high) {
				high = x[i]+r[i];
			}
		}
		//更新最小圆排列长度
		if(high - low <length) {
			length = high - low;
			for (int i = 0; i < n; i++) {
				bestr[i] = r[i];
			}
		}
	}
	//回溯法
	public static void search(int t) {
		//停止搜索
		if(t == n) {
			compute();
		}else {
			for (int i = t; i < n; i++) {
				swap(r, t, i);
				double centerx = center(t);
				//当前圆排列长度为当前圆的圆心横坐标+该圆的半径+第一个圆的半径
				//如果当前结点的圆排列长度小于length，则继续搜索，否则直接回溯
				if(centerx + r[t] + r[1] <length) {
					x[t] = centerx;
					search(t+1);
				}
				swap(r, t, i);
			}
		}
	}
	
	//交换位置
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
		System.out.println("最优圆排列长度为："+length);
		System.out.print("最优圆排列顺序对应的半径分别为：");
		for (int i = 1; i < n; i++) {
			System.out.print(bestr[i]);
			if(i != n-1) {
				System.out.print(" , ");
			}
		}
	}
}
