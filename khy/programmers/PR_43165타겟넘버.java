import java.io.*;
import java.util.*;

class Solution {
    
    static int[] numbers;
    static int target;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        this.numbers = numbers;
        this.target = target;
        
        //dfs의 첫번째 매개값은 index, 두번째 매개값은 현재 합
        dfs(0,0);
        
        int answer = 0;
        answer = count;
        return answer;
    }
    
    public void dfs(int idx, int result){
        
        //만약 idx가 nubers의 legnth와 같다면 numbers의 숫자가 모두 계산된 상태
        if(idx == numbers.length){
            if(result == target) count++;
            return;
        }
        
        dfs(idx+1,result+numbers[idx]);
        dfs(idx+1,result-numbers[idx]);
    }
}