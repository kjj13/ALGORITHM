package Array_2;

public class Array2_for {
    public static void main(String[] args) {
        int[] nums=  { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k = 7;

        System.out.println(subArraySum(nums,k));
    }
//  1. for문
    public static int subArraySum(int[] nums,int k){
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
//              break가 없어서 착각했음..
                if(sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
