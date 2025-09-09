package com.example.clsoftlab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayItemListDto {
	
	private String itemCode;
    private String itemName;
    private String itemType;
    private String taxYn;
    private String roundType;
    private String useYn;

}
