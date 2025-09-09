class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (c1,c2) -> Integer.compare(c1[1], c2[1]));

        PriorityQueue<Integer> heap = new PriorityQueue<>((d1, d2) -> Integer.compare(d2, d1));

        int limit = 0;

        for(int[] course : courses){
            
            int duration = course[0];
            int last = course[1];

            limit += duration;

            heap.add(duration);

            if(limit > last) limit -= heap.poll();
        }
        return heap.size();
    }
} 