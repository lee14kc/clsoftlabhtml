package com.example.clsoftlab.dto.pay;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayRuleRequestDto {

	@NotEmpty(message = "항목 코드는 필수입니다.")
    private String itemCode;

    @NotEmpty(message = "계산 방식은 필수입니다.")
    private String ruleType;
    
    private String formula;
    private BigDecimal fixedValue;

    @NotNull(message = "시작일은 필수입니다.")
    private LocalDate fromDate;

    @NotNull(message = "종료일은 필수입니다.")
    private LocalDate toDate;

    @NotEmpty(message = "사용여부는 필수입니다.")
    private String useYn;
    
    private String note;
}
