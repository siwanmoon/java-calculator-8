package calculator.controller;

import java.util.ArrayList;

import calculator.model.CheckCustomSeparator;

public class CalculatorController {
    public static void cpu(String calculatorInput) { //입력받은 문자열을 model과 view로 전송
        ArrayList<String> Separator = new ArrayList<>(); // 구분자를 ArrayList로 저장
        Separator.add(",");
        Separator.add(":");

        String customSeparator = CheckCustomSeparator.getSeparator(calculatorInput);

        // 새로운 커스텀 구분자가 존재할시 구분자 목록에 추가
        if(!customSeparator.equals(",") && !customSeparator.equals(":")) {
            Separator.add(customSeparator);
        }
    }
}
