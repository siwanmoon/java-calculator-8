package calculator.controller;

import java.util.ArrayList;
import calculator.common.Constants;
import calculator.model.CalculateString;
import calculator.model.CheckCustomSeparator;
import calculator.model.IntegrityCheck;
import calculator.model.SplitBySeparator;
import calculator.view.InputView;

public class CalculatorController {
    public static void cpu() { // 입력받은 문자열을 model과 view로 전송
        String calculatorInput = InputView.getInput();

        ArrayList<String> Separator = new ArrayList<>(Constants.DEFAULT_SEPARATOR); // 구분자를 ArrayList로 저장

        // 새로운 커스텀 구분자가 존재할시 구분자 목록에 추가
        String customSeparator = CheckCustomSeparator.getSeparator(calculatorInput);

        if(!customSeparator.isEmpty()) {
            Separator.add(customSeparator);
        }

        // 입력받은 문자열을 구분자로 나눠줌
        String[] dividedInput = SplitBySeparator.checkChar(calculatorInput, Separator);

        // 구분자로 나눠준 후 입력값에 문자열이 남아있는지 확인하고 IllegalArgumentException 출력
        IntegrityCheck.checkUnexpectedString(dividedInput);

        // 문자열화 된 숫자들간의 덧셈을 진행해줌
        long addResult = CalculateString.addString(dividedInput);

        // 더해진 값을 출력해줌
    }
}
