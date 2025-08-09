// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I kept track of last sign (i start with calculated = 0 and do operations in format 0+....), calculated value and tail (last value after last Op) -> if its a digit, I update the curr, else I do the operation -> if it was meant to be added (last sign determines) I add it, etc etc, now when I need to multiply or divide I updated calculated to be calculated - tail so calculated doesn't hold any last value and this value is multiplied or divided by curr and added to the calculated answer.

class Solution {
    public int calculate(String s) {
        if(s.length()==1) return s.charAt(0)-'0';
        int calculated = 0, curr = 0, tail = 0;
        char lastOp = '+';
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) curr = curr*10 + (c-'0');
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastOp=='+'){
                    calculated += curr;
                    tail = curr; 
                }
                if(lastOp=='-'){
                    calculated -= curr;
                    tail = -curr;
                }
                if(lastOp=='*'){
                    calculated = calculated - tail + tail*curr;
                    tail = tail*curr;
                }
                if(lastOp=='/'){
                    calculated = calculated - tail + tail/curr;
                    tail = tail/curr;
                }
                curr=0;
                lastOp=c;
            }
        }
        return calculated;
    }
}
