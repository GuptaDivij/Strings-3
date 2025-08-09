// Time Complexity : O(logN) - base 10
// Space Complexity : O(1) - constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I kept arrays as dictionary for numbers below20, tens and thousands. I keep a count of thousands - for 0 I add nothing, for 1 add thousand, 2 Million, etc. I iterate while num > 0 -> I get triplet num%1000 and use the arrays to get the value in words, now after this I add the thousdand value to make the number. I keep doing this while incrementing thousdand count. 

class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
        String[] below20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            int triplet = num % 1000;
            if (triplet > 0) {
                String curr = "";
                if (triplet < 20) curr = curr + below20[triplet];
                else if (triplet < 100) curr = curr + tens[triplet/10] + " " + below20[triplet%10];
                else {
                    curr = curr + below20[triplet/100] + " Hundred ";
                    if(triplet%100 < 20) curr = curr + below20[triplet%100]; 
                    else curr = curr + tens[(triplet%100)/10] + " " + below20[triplet%10];
                }
                res.insert(0, curr.trim() + thousands[i]);
            }
            num = num / 1000;
            i++;
        }
        return res.toString().trim();
    }
}
