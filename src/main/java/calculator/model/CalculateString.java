package calculator.model;

import java.util.ArrayList;

public class CalculateString {
    private static final String LARGE_NUMBER_INPUT_EXCEPTION =
            "너무 큰 값을 입력했습니다. 작은 값을 입력해 주십시오.";
    private static final String LARGE_NUMBER_SUM_EXCEPTION =
            "덧셈의 값이 너무 큽니다. 작은 값을 입력해 주십시오.";

    // 문자열간의 덧셈을 실행하고 long을 넘어가면 예외 발생
    public static long addString(ArrayList<String> inputString) {
        long addResult = 0;

        for (String numberString : inputString) {
            // NULL 입력시 0 반환
            if (numberString.isEmpty()) {
                continue;
            }

            try {
                long numberToAdd = Long.parseLong(numberString);
                addResult = Math.addExact(addResult, numberToAdd);
            } catch (NumberFormatException nfe) {
                // 더해야 할 문자열이 너무 크면 예외 발생
                throw new IllegalArgumentException(LARGE_NUMBER_INPUT_EXCEPTION);
            } catch (ArithmeticException ae) {
                // 더해진 문자열이 너무 크면 예외 발생
                throw new IllegalArgumentException(LARGE_NUMBER_SUM_EXCEPTION);
            }
        }

        return addResult;
    }
}
