class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> arr=new ArrayList<>();
        int ind=0;
        if(intervals.length==0||intervals==null){
            return arr.toArray(new int[0][]);

        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int[] it:intervals){
            if(it[0]<=end){
                end=Math.max(end,it[1]);
            }
            else{
                arr.add(new int[]{start,end});
                start=it[0];
                end=it[1];  
            }
        }
        arr.add(new int[]{start,end});
        return arr.toArray(new int[0][]);
    }
}

