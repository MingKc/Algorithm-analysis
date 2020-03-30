#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define N 100
#define INF 65535

struct node{
	double x;
	double y;
}point[N];

//�Ƚϴ�С
double cmp(double left,double right){
	if(left>right){
		return right;
	}else{
		return left;
	} 
}

//�����������
double distance(int left,int right){
	return sqrt((point[left].x - point[right].x) * (point[left].x - point[right].x) + ((point[left].y - point[right].y) * (point[left].y - point[right].y)));
}

//�������̾���
double closest(int left,int right){
	//��ʼ������ΪINF
	double dis=INF;

	//ֻ��������
	if(left-right==1){
		return distance(left,right);
	}

	//ֻ��������
	if (left-right == 2) {
		return cmp(distance(0, 1), cmp(distance(0, 2), distance(1, 2)));
	}

	//����������
	int mid=(left+right)/2;
	double leftDis=closest(left,mid);
	double rightDis=closest(mid+1,right);

	//�ҳ���Сֵdis
	dis=cmp(leftDis,rightDis);

	//�洢�ָ������߾���Ϊdis�ĵ�
	int temp[N];
	int k=0;
	for(int i=left;i<=right;i++){
		//�ҳ����Ͼ���ĵ�
		if((fabs(point[mid].x-point[i].x))<=dis){
			temp[k++]=i;
		}
	}
	//��������̵ľ���
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
		//����x��С�����˳������
		return m.x - n.x;
	}else{ 
		//��x��ȵ�ʱ�򣬰���y�ĴӴ�С��˳������ 
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
	printf("����Ծ���Ϊ��%.2f\n",closest(0,n-1)/2);

	system("pause");
	return 0;
}