package Twelve;

public class ExperimentTwleve {
	//ͼ�Ķ������
	private static int n = 5;
	//����Ϳ����ɫ��
	private static int m = 4;
	//ͼ
	private static int[][] graph= new int [][]{{0,0,0,0,0,0},{0,0,1,1,1,0},{0,1,0,1,1,1},{0,1,1,0,1,0},{0,1,1,1,0,1},{0,0,1,0,1,0}};
	//��ɫ����
	private static int[] color = new int[20];
	//��ɫ��������
	private static int count = 0;
	
	public static boolean isPainted(int point) {
		for(int i=1;i<=n;i++){
	        if(graph[point][i] == 1 && (color[point]==color[i])){
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void  search(int point){
	    if(point>n){
	        for(int i=1;i<=n;i++){
	            System.out.print(color[i] + " ");
	        }
	        count++;
	        System.out.println();
	    }
	    else{
	        for(int i=1;i<=m;i++){
	            color[point]=i;
	            if(isPainted(point)) {
	                search(point+1);
	            }
	            color[point]=0;
	        }
	    }
	}
	
	public static void main(String[] args) {
		search(1);
		if(count == 0) {
			System.out.println("No");
		}else {			
			System.out.println("�ܹ���"+count+"����ɫ����");
		}
	}
}
