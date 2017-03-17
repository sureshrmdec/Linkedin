/*
Total Accepted: 86978
Total Submissions: 330372
Difficulty: Medium
Contributors: Admin
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/


public class Solution {
	public int evalRPN(String[] tokens) {

		int res = 0;

		Stack<String> stack = new Stack<String>();

		String operators = "+-*/";

		for (String s : tokens) {
			if (!operators.contains(s)) {
				stack.push(s);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				int index = operators.indexOf(s);

				switch (index) {
					case 0:
						stack.push(String.valueOf(a + b));
						break;
					case 1:
						stack.push(String.valueOf(b - a));
						break;
					case 2:
						stack.push(String.valueOf(a * b));
						break;
					case 3:
						stack.push(String.valueOf(b / a));
						break;
				}

			}
		}

         res = Integer.valueOf(stack.pop());
		
		return res;
	}
}
