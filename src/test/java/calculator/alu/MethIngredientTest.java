package calculator.alu;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("도메인 - MethIngredient 테스트")
class MethIngredientTest {

    static Stream<Arguments> invalidMethIngredients() {
        return Stream.of(
            Arguments.of(List.of("2", " ", "4"), "blank")
        );
    }

    @DisplayName("생성자 유효성 검사 테스트")
    @ParameterizedTest
    @MethodSource("invalidMethIngredients")
    void initMethIngredient_무효값_예외처리(List<String> methIngredients, String expected) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> methIngredients.stream().map(MethIngredient::new).toList()
        ).withMessage("유효하지 않은 인자 : " + expected);
    }
}
