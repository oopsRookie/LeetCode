package LeetCode;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//leetcode 20. Valid Parentheses
//Given a string s containing
//just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//1 <= s.length <= 10^4
//Input: s = "{[]}"
//Output: true
public class B0001_20_valid_parentheses {
    static HashMap<Character, Character> right2left = new HashMap<>();

    static {
        right2left.put(')', '(');
        right2left.put('}', '{');
        right2left.put(']', '[');
    }


    public static void main(String[] args) {
        B0001_20_valid_parentheses obj = new B0001_20_valid_parentheses();
        String str1 = "()";
        String str2 = "()[]{}";
        String str3 = "(]";
        String str4 = "{[]}";
        String str5 = "{[";

//        boolean valid = obj.isValidByStack(str1);
//        boolean valid = obj.isValidByRecursive(str4);
        boolean valid = obj.isValidByRegex(str4);
        System.out.println("it is " + valid);

    }

    //solved by stack.  this is the best solution.
    //tc: O(n)
    //sc: O(1) ?
    boolean isValidByStack(String s) {
        if (s.length() % 2 != 0) {          //length of valid string must be even
            return false;
        }
        HashMap<Character, Character> right2left = new HashMap<>();
        right2left.put(')', '(');
        right2left.put('}', '{');
        right2left.put(']', '[');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch :
                chars) {
            if (right2left.containsKey(ch)) {      //right bracket,pop from stack
                if (stack.isEmpty()) {            //stack is empty that is not match too
                    return false;
                }
                Character peek = stack.pop();
                if (!peek.equals(right2left.get(ch))) {
                    return false;
                }
            } else {                                             //left bracket,push to stack
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    //inspired by https://leetcode-cn.com/problems/valid-parentheses/solution/20you-xiao-gua-hao-3chong-jie-fa-zhan-di-gui-zheng/
    //but it's really really slow !!! 765ms and 39.8MB
    boolean isValidByRegex(String s){
        String regex = "\\[\\]|\\{\\}|\\(\\)";            //match []、{}、()
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            s = matcher.replaceAll("");
            matcher = pattern.matcher(s);
        }
        System.out.println(s);
        return s.isEmpty();
    }


    //inspired by https://leetcode-cn.com/problems/valid-parentheses/solution/20you-xiao-gua-hao-3chong-jie-fa-zhan-di-gui-zheng/
    //it's really slow and huge-memory consumed! 130ms and 60.7 MB
    boolean isValidByRecursive(String s) {
        //base case
        if (s.isEmpty()) {            //empty represents it is valid
            return true;
        }
        if (s.length() % 2 != 0) {          //length of valid string must be even
            return false;
        }

        char firstChar = s.charAt(0);
        if (!right2left.values().contains(firstChar)) {        //if not start with left bracket, it is invalid
            return false;
        }


        //if 0th left bracket meets nth right bracket
        //we can decompose problem to isValid(0,n) && isValid(n,length)

        //find n
        int n = findMatchedRightIndex(s);

        //general case
        if (n == -1) {           //if can not find corresponding n
            return false;
        }
        return isValidByRecursive(s.substring(1, n)) && isValidByRecursive(s.substring(n + 1, s.length()));
    }

    //find index of the right parenthesis corresponding to the first char of string
    int findMatchedRightIndex(String s) {
        int n = -1;
        int count = 0;
        char firstChar = s.charAt(0);
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == firstChar) {                                  //if meet same left bracket
                count++;
            } else if (right2left.containsKey(ch)
                    && right2left.get(ch).equals(firstChar)) {        //if meet corresponding right bracket
                count--;
                if (count == 0) {             //it's n
                    n = index;
                    break;
                }
            }
            //below notation is equivalent to above code
//            if (ch == firstChar) count++;
//            if (firstChar == right2left.get(ch)) count--;
//            if (count == 0) return index;
        }
        return n;
    }


}

//first, we could use stack to solve this problem
//then,i have another ideas,like:
//1、this problem is equivalent to
// ①if this string is symmetrical              note: it is false, the valid string may not symmetrical
// ②and the length of the string is even.
//2、traverse this string and compare each single character
//3、can we use recursive call to solve this? aka, recursive call is also a stack thing.


//note: inspired by https://leetcode-cn.com/problems/valid-parentheses/solution/20you-xiao-gua-hao-3chong-jie-fa-zhan-di-gui-zheng/
//there are two more solutions,
//one is recursive call,another is regex and replacement