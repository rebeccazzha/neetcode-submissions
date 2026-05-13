class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (res.size() == 0 || res.get(res.size() - 1) < num) {
                res.add(num);
            } else {
                int index = binary(res, num);
                res.set(index, num);
            }
        }
        return res.size();
    }

    public int binary(List<Integer> res, int num) {
        int left = 0;
        int right = res.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (res.get(mid) > num) {
                right = mid - 1;
            } else if (res.get(mid) < num) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
