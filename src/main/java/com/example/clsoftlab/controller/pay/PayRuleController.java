package com.example.clsoftlab.controller.pay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay/pay-rule")
public class PayRuleController {

	
	@GetMapping("")
	public String payRuleList() {
		
		return "pay/pay-rule/list";
	}
}
