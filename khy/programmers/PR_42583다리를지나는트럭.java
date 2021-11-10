import java.io.*;
import java.util.*;

class Solution {
    
    //현재 다리 무게
    static int totalWeight = 0;
    //현재 다리위에 있는 트럭
    static Queue<Integer> queue = new LinkedList<>();
    
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {    
        int idx = 0;
        int second = 0;
        
        //먼저 다리를 다 채운다.
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }

        while(true){    
            //빠져나간 트럭의 무게를 빼준다.
            totalWeight-=queue.poll();
            
            if(idx == truck_weights.length){
                break;
            }
            
            if(weight >= totalWeight + truck_weights[idx]){
                queue.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            } else{
                queue.offer(0);
            }
            second++;
        }
        
        second += bridge_length;
        
        int answer = second;
        return answer;
    }
}