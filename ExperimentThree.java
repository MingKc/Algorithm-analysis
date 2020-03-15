package Experiment;

public class ExperimentThree {
	public static void main(String[] args) {
		int[] T= {0,1,2,3,4,5,6,7,8,9,10};
		int x=3;
		System.out.println(search(T, x));
		System.out.println(search(T, x));
	}
	
//	顺序查找
	public static int search(int[]T,int x) {
		int j=0;
		for (int i = 0; i < T.length; i++) {
			if(T[i]==x) {
				j=i;
				break;
			}
		}
		return j;
	}
	
//	二分查找
	public static int binarySearch(int[]T,int x) {
		int j=0;
		int low,high,mid;
		low=0;
		high=T.length-1;
		while(high>=low) {
			mid=(high+low)/2;
			if(T[mid]==x) {
				return mid;
			}else if(T[mid]>x) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return j;
	}
}
