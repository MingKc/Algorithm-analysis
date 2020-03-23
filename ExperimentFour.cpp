#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

//归并
void merge(int arr[],int start,int mid,int end){
	int left[SIZE];
	int right[SIZE];

	int r=0,l=0;

	//复制原数组
	for(int i=start;i<=mid;i++){
		left[l++]=arr[i];
	}
	for(int j=mid+1;j<=end;j++){
		right[r++]=arr[j];
	}

	int m=0,n=0;
	int flag=start;
	while(m<(mid-start+1)&&n<(end-mid)){
		if(left[m]>right[n]){
			arr[flag++]=right[n++];
		}else{
			arr[flag++]=left[m++];
		}
	}

	while(m<(mid-start+1)){
		arr[flag++]=left[m++];
	}
	while(n<(end-mid)){
		arr[flag++]=right[n++];
	}

}

//归并排序
void MergeSort(int arr[],int start,int end){
	if(start<end){
		int mid=start+(end-start)/2;
		MergeSort(arr,start,mid);
		MergeSort(arr,mid+1,end);
		merge(arr,start,mid,end);
	}
}




int main(){
	int n=7;
	int arr[]={8,2,5,4,1,3,5};

	MergeSort(arr,0,n-1);
		for(int i=0;i<n;i++){
		printf("%d ",arr[i]);
	}
	
	//system("pause");
	return 0;
}