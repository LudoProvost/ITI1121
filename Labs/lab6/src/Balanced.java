import java.util.Stack;

/**
 *
 * @author Marcel Turcotte, Université d'Ottawa/University of Ottawa
 */

public class Balanced {

    public static boolean algo1( String s ) {

//        int curly = 0;
//        int square = 0;
//        int round = 0;
        ArrayStack<Character> stack = new ArrayStack<>(s.length());

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
            case '{':
//                curly++;
                stack.push('{');
                break;
            case '}':
//                curly--;
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                break;
            case '[':
//                square++;
                stack.push('[');
                break;
            case ']':
//                square--;
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                break;
            case '(':
//                round++;
                stack.push('(');
                break;
            case ')':
//                round--;
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
//        return curly == 0 && square == 0 && round == 0;
        return stack.isEmpty();
    }

    public static void main( String[] args ) {

        Stack<String> stack;
        stack = new DynamicArrayStack<String>();

//        for ( int i=0; i<args.length; i++ ) {
//            System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo1( args[ i ] ) );
//        }
    }
}
