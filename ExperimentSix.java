package Experiment;

import java.util.ArrayList;

public class ExperimentSix {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(5);
		list.add(15);
		list.add(52);
		list.add(3);
		list.add(8);
		list.add(42);
		list.add(17);
		list.add(32);
		int k=4;
		System.out.println("第"+k+"小元素是："+smallestK(list, k));
	}

	// 找第K小元素
	public static int smallestK(ArrayList<Integer> arr, int k) {
		int bottom = 0;
		int top = arr.size();
		while (bottom < top) {
			int i = 0;
			int left = bottom;
			int right = bottom;
			int index = chooseMid(arr, bottom, top);
			while (right < top) {
				if (arr.get(right) < index) {
					int temp = arr.get(left);
					arr.set(left, arr.get(right));
					arr.set(right, temp);
					left++;
				}
				if (arr.get(right) == index) {
					i = right;
				}
				right++;
			}
			arr.set(i, arr.get(left));
			arr.set(left, index);
			System.out.println(arr);
			if (left + 1 < k) {
				bottom = left + 1;
			} else if (left + 1 > k) {
				top = left;
			} else {
				return index;
			}
		}
		return -1;
	}

	public static int select(ArrayList<Integer> arr) {
		// 排序
		for (int i = 1; i < arr.size(); i++) {
			int x = i;
			int temp = arr.get(x);
			while (x > 0 && temp < arr.get(x - 1)) {
				arr.set(x, arr.get(x - 1));
				x--;
			}
			arr.set(x, temp);
		}
		// 返回每组的中位数
		int mid = (arr.size() - 1) / 2;
		return arr.get(mid);
	}

	// 选择每组中位数集合中的中位数
	public static int chooseMid(ArrayList<Integer> arr, int left, int right) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> temp = null;
		while (left + 5 < right) {
			for (int i = left; i < right; i++) {
				temp = new ArrayList<Integer>();
				temp.add(arr.get(i));
			}
			int mid = select(temp);
			list.add(mid);
			left += 5;
		}
		for (int i = left; i < right; i++) {
			temp = new ArrayList<Integer>();
			temp.add(arr.get(i));
		}
		int mid = select(temp);
		list.add(mid);
		return select(list);
	}
}
