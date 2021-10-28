import java.io.*;
import java.util.*;

class Solution {
    
    public String[][] tickets;
    public ArrayList<String> answers = new ArrayList<>();
    public boolean[] used;
    
    public String[] solution(String[][] tickets) {
        
        this.tickets = tickets;
        used = new boolean[tickets.length];
        
        dfs("ICN","ICN",0);
        answers.sort(Comparator.naturalOrder());
        String[] result = answers.get(0).split(" ");
     
        return result;
    }
    
    public void dfs(String start, String path, int count){
        
        if(count == tickets.length){
            answers.add(path);
            return;
        }
        
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !used[i]){
                used[i] = true;
                dfs(tickets[i][1], path+" "+tickets[i][1], count+1);
                used[i] = false;
            }
        }
    }
}