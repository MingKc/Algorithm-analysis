#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define N 100
#define INF 65535

struct node{
	double x;
	double y;
}point[N];

//比较大小
double cmp(double left,double right){
	if(left>right){
		return right;
	}else{
		return left;
	} 
}

//计算两点距离
double distance(int left,int right){
	return sqrt((point[left].x - point[right].x) * (point[left].x - point[right].x) + ((point[left].y - point[right].y) * (point[left].y - point[right].y)));
}

//最近对最短距离
double closest(int left,int right){
	//初始化距离为INF
	double dis=INF;

	//只有两个点
	if(left-right==1){
		return distance(left,right);
	}

	//只有三个点
	if (left-right == 2) {
		return cmp(distance(0, 1), cmp(distance(0, 2), distance(1, 2)));
	}

	//大于三个点
	int mid=(left+right)/2;
	double leftDis=closest(left,mid);
	double rightDis=closest(mid+1,right);

	//找出最小值dis
	dis=cmp(leftDis,rightDis);

	//存储分割线两边距离为dis的点
	int temp[N];
	int k=0;
	for(int i=left;i<=right;i++){
		//找出符合距离的点
		if((fabs(point[mid].x-point[i].x))<=dis){
			temp[k++]=i;
		}
	}
	//纵坐标最短的距离
	for(int i=0;i<k;i++){
		for(int j=i+1;j<k;j++){
			if (point[temp[j]].y-point[temp[i]].y<dis)
				dis = cmp(dis,distance(temp[i], temp[j]));
		}
	}

	return dis;
}


int qcmp(const void* a, const void* b) 
{
	struct node m = *(struct node*)a;
	struct node n = *(struct node*)b;
	if (m.x != n.x){
		//按照x从小到大的顺序排序
		return m.x - n.x;
	}else{ 
		//当x相等的时候，按照y的从大到小的顺序排序 
		return m.y - n.y;
	}
}


int main(){
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%lf %lf",&point[i].x,&point[i].y);
	}
	qsort(point, n, sizeof(point[0]), qcmp);
	printf("最近对距离为：%.2f\n",closest(0,n-1)/2);

	system("pause");
	return 0;
}