import java.io.*;
import java.util.*;

class Solution {
    
    public static Queue<Integer> queue = new LinkedList<>();
    public static ArrayList<Integer> arr = new ArrayList<>();
    
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        for(int i=0; i<progresses.length; i++){
            if((100-progresses[i])%speeds[i] == 0){
                queue.offer((100-progresses[i])/speeds[i]);
            } else if((100-progresses[i])%speeds[i] != 0){
                queue.offer((100-progresses[i])/speeds[i]+1);
            }
           
            
        }
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek()<=temp){
                queue.poll();
                count++;
            }
            arr.add(count);
        }
        
        int[] answer = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        if(arr.size() == 0){
            answer = new int[1];
        }
        return answer;
    }
}