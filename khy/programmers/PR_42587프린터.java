import java.io.*;
import java.util.*;

class Solution {
    
    static Queue<Docu> queue = new LinkedList<>();
    static int[] importArr;
    static int rank = 0;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        for(int i=0; i<priorities.length; i++){
            Docu doc = new Docu(priorities[i],i);
            queue.offer(doc);
        }
        
        importArr = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(importArr);
        
        int nowImp = importArr.length-1;
        
        while(!queue.isEmpty()){
            Docu doc = queue.poll();    
            if(doc.importance == importArr[nowImp]){
                rank++;
                nowImp--;
                if(doc.loc == location){
                    answer = rank;
                    return answer;
                }
            } else{
                queue.offer(doc);
            }
        }

        return answer;
    }
    
    
}

class Docu{
    int importance;
    int loc;
    
    Docu(int importance, int loc){
        this.importance = importance;
        this.loc = loc;
    }
}