public class NumberOfInversions {
    static int divide(int arr[], int start, int end){
        int count=0;
        
        if(start<end){
            int mid=(start+end)/2;
            count+=divide(arr,start,mid);
            count+=divide(arr, mid+1, end);
            count+=conquer(arr, start, mid , end);
        }
        return count;
    }

    static int conquer(int arr[], int start, int mid, int end){
        int count=0;
        int temp[]=new int[end-start+1];
        int ind=0;
        int i=start;
        int j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[ind]=arr[i];
                i++;
            }
            else{
                temp[ind]=arr[j];
                count+=(mid-i+1);
                j++;

            }
            ind++;
        }

        while(i<=mid){
            temp[ind]=arr[i];
            i++;
            ind++;
        }

        while(j<=end){
            temp[ind]=arr[j];
            j++;
            ind++;
        }

        for(int k=start, l=0; k<=end;k++, l++){
            arr[k]=temp[l];

        }
        return count;

    }


    public static void main(String args[]){
        int arr[]={4, 3 , 2, 6 , 1 ,3 , 5};
        int ans=divide(arr, 0 , arr.length-1);
        for(int i:arr)System.out.println(i);
        System.out.println(ans);

    }
    
}
