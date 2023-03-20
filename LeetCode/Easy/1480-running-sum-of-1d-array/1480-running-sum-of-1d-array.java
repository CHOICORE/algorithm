class Solution {
    public int[] runningSum(int[] nums) {
        // 합계 변수 초기화
        int sum = 0;
        
        // 저장 배열 초기화
        int[] result = new int[nums.length];

        // 순회 돌면서 sum에 값을 누적하고 배열에 저장
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            result[i] = sum;
        }
        // 저장 배열 반환
        return result;

    }
}