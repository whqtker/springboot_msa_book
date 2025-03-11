package org.msa.springboot_msa_book.multiplication.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.msa.springboot_msa_book.multiplication.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

// @RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class MultiplicationServiceTest {

    // @MockBean
    // Mock: 실제 모듈과 비슷하게 동작하도록 정의한 가짜 객체
    @Mock
    private RandomGeneratorService randomGeneratorService;

    // @Autowired
    @InjectMocks
    private MultiplicationServiceImpl multiplicationService;

    @Test
    public void createRandomMultiplicationTest() {
        // given (randomGeneratorService 가 처음에 50, 나중에 30을 반환하도록 설정)
        // BDD(Behavior Driven Development): 행위 주도 개발
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        // when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        // assert
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}
