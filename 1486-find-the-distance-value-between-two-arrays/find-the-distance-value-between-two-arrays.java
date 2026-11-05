class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ckt=0;
        for(int i:arr1)
        {
            boolean flag=true;
            for(int j:arr2)
            {
                if(Math.abs(j-i)<=d)
                {
                    flag=false;
                }
            }
            if(flag) ckt++;
        }
        return ckt;
    }
}