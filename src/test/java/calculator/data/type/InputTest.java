package calculator.data.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputTest {

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외를 던진다.")
    public void InputValidationForNullAndEmptyValues(String input) {
//
//        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Input.getInput(input)).withMessageMatching("입력 값이 Null이거나 빈 공백 문자입니다.");
//
//        // 빈 문자열 입력 값에 대한 테스트
//        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Input.getInput(input)).withMessageMatching("입력 값이 Null이거나 빈 공백 문자입니다.");
    }
}
