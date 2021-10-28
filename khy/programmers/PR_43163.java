import java.io.*;
import java.util.*;

class Solution {
    String[] words;
    int count = Integer.MAX_VALUE;
    boolean[] used;
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.used = new boolean[words.length];
        dfs(begin, target, 0);
        
        if(count == Integer.MAX_VALUE){
            count = 0;
        }
        return count;
    }
    
    public void dfs(String nowWord, String target, int stepCount){
        if(nowWord.equals(target)){
            count = count>stepCount?stepCount:count;
            return;
        }
        for(int i=0; i<words.length; i++){
           if(!used[i]){
                String temp = words[i];
                int compare = 0;
                for(int j=0; j<temp.length(); j++){
                    if(compare>1) break;
                    if(nowWord.charAt(j)!=temp.charAt(j)){
                        compare++;
                    }
                }
                if(compare == 1){
                    used[i] = true;
                    dfs(words[i],target,stepCount+1);
                    used[i] = false;
                }
            }
        }
    }
}