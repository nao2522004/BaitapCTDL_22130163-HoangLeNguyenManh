import java.util.Arrays;
import java.util.Stack;

public class MyLIFO_App {

// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> newStack = new Stack<>();
		for (E arr : array) {
			newStack.push(arr);
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = newStack.pop();
		}
	}

// This method checks the correctness of the given input
// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false   
	public static boolean isCorrect(String input) {
		Stack<Character> newStack1 = new Stack<>();

		for (Character c : input.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				newStack1.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (newStack1.isEmpty()) {
					return false;
				}
				Character open = newStack1.pop();
				if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) {
					return false;
				}

			}
		}
		return newStack1.isEmpty();

	}

// This method evaluates the value of an expression
// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (Character.isDigit(c)) {
				int operand = 0;
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					operand = operand * 10 + Character.getNumericValue(expression.charAt(i));
					i++;
				}
				i--; // Adjust the index after extracting the entire number
				operandStack.push(operand);
			} else if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop '('
			} else if (isOperator(c)) {
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(c);
			}
		}

		while (!operatorStack.isEmpty()) {
			processOperator(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		switch (operator) {
		case '+':
			operandStack.push(operand1 + operand2);
			break;
		case '-':
			operandStack.push(operand1 - operand2);
			break;
		case '*':
			operandStack.push(operand1 * operand2);
			break;
		case '/':
			operandStack.push(operand1 / operand2);
			break;
		}
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static String insertBlank(String expression) {
		StringBuilder sb = new StringBuilder();

		for (char c : expression.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '{' || c == '}'
					|| c == '[' || c == ']') {
				sb.append(" ").append(c).append(" ");
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {

		// test reverse
		Integer[] i = { 1, 2, 3 };
		System.out.println("originalArray: " + Arrays.toString(i));
		reserve(i);
		System.out.println("reverseArray : " + Arrays.toString(i));

		// test isCorrect
		System.out.println("()(())[]{(())} isCorrect: " + isCorrect("()(())[]{(())}")); // true
		System.out.println(" ){[]}() isCorrect: " + isCorrect("){[]}()")); // false

		// test evaluateExpresstion
		String expression = "51+(54*(3+2))";
		String spacedExpression = insertBlank(expression);
		int result = evaluateExpression(spacedExpression);
		System.out.println(spacedExpression + " = " + result);
	}
}