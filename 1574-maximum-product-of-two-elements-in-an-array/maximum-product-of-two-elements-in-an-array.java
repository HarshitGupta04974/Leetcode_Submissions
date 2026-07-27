class Solution {
    public int maxProduct(int[] nums) {
        int largest=-1,secondlargest=-1;
        for(int i:nums)
        {
            if(i>largest)
            {
                secondlargest=largest;
                largest=i;
            }
            else if(i>secondlargest)
            {
                secondlargest=i;
            }
        }
        return((largest-1)*(secondlargest-1));
    }
}