package calculator.model;

public class CalculateString {
    public static long addString(String[] inputString) { // 문자열간의 덧셈을 실행하고 long을 넘어가면 예외 발생
        long addResult = 0;

        for (String s : inputString) {
            try {
                long numberToAdd = Long.parseLong(s);
                addResult = Math.addExact(addResult, numberToAdd);
            } catch (NumberFormatException nfe) { // 더해야 할 문자열이 너무 크면 예외 발생
                throw new IllegalArgumentException("너무 큰 값을 입력했습니다. 작은 값을 입력해 주십시오.");
            } catch (ArithmeticException ae) { // 더해진 문자열이 너무 크면 예외 발생
                throw new IllegalArgumentException("덧셈의 값이 너무 큽니다. 작은 값을 입력해 주십시오.");
            }
        }

        return addResult;
    }
}
