public class Frequency {


    static int findFirstGreatest(int arr[], int num){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>num){
                ans=mid;
                high=mid-1;

            }
            else low=mid+1;


        }
        return ans;
    }



    static void findFreq(int arr[], int ind){
        if(ind>=arr.length)return;

        int start=findFirstGreatest(arr, arr[ind]-1);
        int end=findFirstGreatest(arr, arr[ind]);
        System.out.println("The frequency of "+arr[ind]+" is " + (end-start));
        findFreq(arr, end);
    }


    public static void main(String [] args){
        int arr[]={1, 2, 2 , 2, 3, 3, 3, 5 , 6 ,6 };
        findFreq(arr,0);
    }
    
}
