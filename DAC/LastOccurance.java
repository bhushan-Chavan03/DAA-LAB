public class LastOccurance {

    static int getUpperBound(int arr[], int num){
        int low=0;
        int high=arr.length-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>num){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return ans;
    }


    public static void main(String[]args){
        int arr[]={1, 2, 3, 4 , 4 , 5 , 6 , 6 , 6 , 7};
        int low=0;
        int high=arr.length-1;
        int num=7;
       
       System.out.println(getUpperBound(arr, num-1));

       System.out.println(getUpperBound(arr, num)-1==-1? arr.length-1 :getUpperBound(arr, num)-1);
    }
    
}
