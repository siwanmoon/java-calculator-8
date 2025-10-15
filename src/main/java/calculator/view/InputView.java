package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void getOutput(String answer) {
        System.out.println("결과 : " + answer);
    }
}
