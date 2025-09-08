package com.example.clsoftlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*

프로그램명 : Pay Item Controller

작성자 : 양한재

작성일 : 2025-09-08

수정자 : 

수정일 : 

프로그램 개요 : Pay Item Controller는 급여항목 관련 페이지를 처리하는 컨트롤러 클래스이다.

프로그램 설명 : 

*/

@Controller
@RequestMapping("pay/pay-item")
public class PayItemController {
	
	@GetMapping("")
	public String payItemList() { 
		
		return "pay/pay-item/list";
	}

}
