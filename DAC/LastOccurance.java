public class LastOccurance {


    public static void main(String[]args){
        int arr[]={1, 1, 2, 3, 4 , 4 , 5 , 6 , 6 , 6 , 7};
        int low=0;
        int high=arr.length-1;
        int num=4;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=num){
                ans=mid;
                low=mid+1;
            }
            else if(arr[mid]>num){
                high=mid-1;
            }
           
            
        }
        System.out.println(ans);
    }
    
}
