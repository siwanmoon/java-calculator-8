package calculator.controller;

import java.util.ArrayList;
import calculator.model.CheckCustomSeparator;
import calculator.common.Constants;
import calculator.model.SplitBySeparator;

public class CalculatorController {
    public static void cpu(String calculatorInput) { // 입력받은 문자열을 model과 view로 전송
        ArrayList<String> Separator = new ArrayList<>(Constants.DEFAULT_SEPARATOR); // 구분자를 ArrayList로 저장

        // 새로운 커스텀 구분자가 존재할시 구분자 목록에 추가
        String customSeparator = CheckCustomSeparator.getSeparator(calculatorInput);

        if(!customSeparator.isEmpty()) {
            Separator.add(customSeparator);
        }

        // 입력받은 문자열을 구분자로 나눠줌
        String[] dividedInput = SplitBySeparator.checkChar(calculatorInput, Separator);
    }
}
