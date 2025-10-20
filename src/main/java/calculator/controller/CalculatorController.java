package calculator.controller;

import java.util.ArrayList;
import java.util.List;
import calculator.common.Constants;
import calculator.model.CalculateString;
import calculator.model.CheckCustomSeparator;
import calculator.model.IntegrityCheck;
import calculator.model.SplitBySeparator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    // 입력받은 문자열에서 덧셈 작업 수행
    public static void stringAddCalculator() {
        String calculatorInput = InputView.getInput();

        // 기본 구분자 저장
        ArrayList<String> separator = new ArrayList<>(Constants.DEFAULT_SEPARATOR);

        /*
         * 새로운 커스텀 구분자가 존재할시 구분자 목록에 추가
         * 숫자로만 이뤄져 있으면 경고문 출력
         */
        String customSeparator = CheckCustomSeparator.getSeparator(calculatorInput);

        if (!customSeparator.isEmpty()) {
            separator.add(customSeparator);
        }

        // 입력받은 문자열을 구분자로 나눠줌
        ArrayList<String> dividedInput = SplitBySeparator.checkChar(calculatorInput, separator);

        // 구분자로 나눠준 후 입력값에 문자열이 남아있는지 확인하고 IllegalArgumentException 출력
        IntegrityCheck.checkUnexpectedString(dividedInput);

        // 문자열화 된 숫자들간의 덧셈을 진행해줌
        long addResult = CalculateString.addString(dividedInput);

        // 더해진 값을 출력해줌
        OutputView.printOutput(addResult);
    }
}
