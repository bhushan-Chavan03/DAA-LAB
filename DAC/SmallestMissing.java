public class SmallestMissing{
    public static void main(String []args){
        int nums[] = {0, 1, 2, 3, 4, 5, 6};
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]!=mid){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }

        }
        
        System.out.println(ans);
    }
}