public class MaxSubarraySum {

    static int maxStart=0;
    static int maxEnd=0;

    static int maxCrossingSum(int arr[], int l, int m, int h){
        int sum=0;
        int left_sum=Integer.MIN_VALUE;
        for(int i=0;i>=l;i--){
            sum+=arr[i];
            if(sum>left_sum){
                left_sum=sum;
                maxStart=i;
            }

        }

        sum=0;
        int right_sum=Integer.MIN_VALUE;
        for(int i=m;i<=h;i++){
            sum+=arr[i];
            if(sum>right_sum){
                right_sum=sum;
                maxEnd=i;
            }

        }

        return Math.max(left_sum+right_sum-arr[m], Math.max(left_sum,right_sum));
    }



    static int maxSum(int arr[], int l , int h){
        if(l>h){
            return Integer.MIN_VALUE;
        }
        if(l==h){
            return arr[l];
        }
        int m=(l+h)/2;
        return Math.max(Math.max(maxSum(arr,l,m-1), maxSum(arr,m+1,h)), maxCrossingSum(arr,l,m,h));
    }


    public static void main(String []args){
        int arr[]={2 , -1 , 3 , -4  , 2  ,-1 };
        System.out.println(maxSum(arr,0,arr.length-1));
        System.out.println(maxStart);
        System.out.println(maxEnd);
    }
    
}
