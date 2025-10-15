package calculator;

import calculator.view.InputView;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        String getInput = InputView.getInput();
        CalculatorController.cpu(getInput);
    }
}
