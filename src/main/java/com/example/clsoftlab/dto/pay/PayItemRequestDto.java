package com.example.clsoftlab.dto.pay;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayItemRequestDto {

	private String itemCode;
    private String itemName;
    private String itemType;
    private String taxYn;
    private String taxType;
    private BigDecimal taxPercent;
    private String roundType;
    private String backPayYn;
    private String insuranceYn;
    private String useYn;
    private String note;
}
