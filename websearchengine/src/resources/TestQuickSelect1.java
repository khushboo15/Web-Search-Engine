package resources;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class TestQuickSelect1 {
	 public int findKthLargest(int[] nums, int k) {
	        int start = 0, end = nums.length - 1, index = nums.length - k;
	        while (start < end) {
	            int pivot = partion(nums, start, end);
	            if (pivot < index) start = pivot + 1; 
	            else if (pivot > index) end = pivot - 1;
	            else return nums[pivot];
	        }
	        return nums[start];
	    }
	    
	    private int partion(int[] nums, int start, int end) {
	        int pivot = start, temp;
	        while (start <= end) {
	            while (start <= end && nums[start] <= nums[pivot]) start++;
	            while (start <= end && nums[end] > nums[pivot]) end--;
	            if (start > end) break;
	            temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	        }
	        temp = nums[end];
	        nums[end] = nums[pivot];
	        nums[pivot] = temp;
	        return end;
	    }
	    
	    public static void main(String[] arr) {
	    	TestQuickSelect1 obj = new TestQuickSelect1();
	    	HashMap<String, Integer> e = new HashMap<String, Integer>();
	    	e.put("a", 1);
	    	e.put("b",5);
	    	e.put("c",3);
	    	e.put("d",4);
	    	
	    	final int[] fre = new int[e.size()];
	    	int i = 0;
	    	for (final int value : e.values()) {
	    		fre[i++] = value;
	        }
	    	final int kthLargestFreq = obj.findKthLargest(fre, 2);
	    	final String[] topK = new String[2];
	    	i = 0;
	    	int k =2;
	    	for (final java.util.Map.Entry<String, Integer> entry : e.entrySet()) {
	            if (entry.getValue().intValue() >= kthLargestFreq) {
	                topK[i++] = entry.getKey();
	                if (i == k) {
	                    break;
	                }
	            }
	        }
			
			for(String s:topK){
				System.out.println(s);
			}
		}
}
