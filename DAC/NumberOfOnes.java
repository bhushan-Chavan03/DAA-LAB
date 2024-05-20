public class NumberOfOnes {
    public static void main(String []args){
        int nums[] = {0, 0, 0};
        int low=0;
        int high=nums.length-1;
        int start=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==1){
                high=mid-1;
                start=mid;
            }
            else low=mid+1;
        }
         
        if(start==-1)System.out.println(0);
        else System.out.println( nums.length -start);
    }

    
    
}
