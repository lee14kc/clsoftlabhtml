package com.example.clsoftlab.dto.pay;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayItemRequestDto {

	@NotEmpty (message = "항목코드는 필수입니다.")
	private String itemCode;
	
	@NotEmpty (message = "항목명은 필수입니다.")
    private String itemName;
	
	@NotEmpty (message = "유형은 필수입니다.")
    private String itemType;
	
	@NotEmpty (message = "과세여부는 필수입니다.")
    private String taxYn;
    private String taxType;
    private BigDecimal taxPercent;
    
	@NotEmpty (message = "절사방식은 필수입니다.")
    private String roundType;
	
	@NotEmpty (message = "환급여부는 필수입니다.")
    private String backPayYn;
	
	@NotEmpty (message = "4대 보험 여부는 필수입니다.")
    private String insuranceYn;
	
	@NotEmpty (message = "사용여부는 필수입니다.")
    private String useYn;
    private String note;
}
