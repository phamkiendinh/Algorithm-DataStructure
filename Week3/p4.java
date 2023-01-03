
/*
 * Write a program that reads in a sequence of characters, 
 * and determines whether its parentheses, brackets and curly braces are balanced.
 * []: balanced 
 * {}: balanced
 * (): balanced
 * (){{[]}}(): balanced
 * {): not balanced
 * {{[[}}]]: not balanced
 */
public class p4 {
    public static void main(String[] args) {
        String str = "{[()]}";
        char[] array = new char[str.length()];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == ']' || str.charAt(i) == '{' || str.charAt(i) == '}' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                array[index] = str.charAt(i);
                index++;
            }
        }
        System.out.println("Inside second loop");
        boolean balance = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                if (array[i + 1] != ')' && array[array.length - 1 - i] != ')') {
                    balance = false;
                    break;
                }
            }
            else if (array[i] == '{') {
                if (array[i + 1] != '}' && array[array.length - 1 - i] != '}') {
                    balance = false;
                    break;
                }
            }
            else if (array[i] == '[') {
                if (array[i + 1] != ']' && array[array.length - 1 - i] != ']') {
                    balance = false;
                    break;
                }
            }
            else {
                continue;
            }
        }

        if (balance) {
            System.out.println("It is balanced");
        }
        else {
            System.out.println("It is unbalanced");
        }
    }
}
