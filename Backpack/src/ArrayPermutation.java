import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPermutation {
    static void swap(int nums[], int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

    static void permutations(ArrayList<int[]> res,
                             int[] nums, int l, int h)
    {

        if (l == h) {
            res.add(Arrays.copyOf(nums, nums.length));
            return;
        }

        for (int i = l; i <= h; i++) {

            swap(nums, l, i);

            permutations(res, nums, l + 1, h);

            swap(nums, l, i);
        }
    }

    static ArrayList<int[]> permute(int[] nums)
    {
        ArrayList<int[]> res = new ArrayList<int[]>();
        int x = nums.length - 1;

        permutations(res, nums, 0, x);
        return res;
    }
}
