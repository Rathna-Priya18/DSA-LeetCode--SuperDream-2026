class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->-(a[0]-b[0]));
        int n = aliceValues.length;
        for(int i = 0;i<n;i++){
            int[] arr= new int[2];
            arr[0] = aliceValues[i]+bobValues[i];
            arr[1] = i;
            pq.offer(arr);
        }
        int aliceScore = 0,bobScore = 0;
        boolean aliceturn = true;
        while(!pq.isEmpty()){
                int[] out = pq.poll();
                int indx = out[1];
            if(aliceturn){
                aliceScore += aliceValues[indx];
                aliceturn = false;
            }
            else{
                bobScore += bobValues[indx];
                aliceturn = true;
            }
        }

        return Integer.compare(aliceScore, bobScore);
    }
}