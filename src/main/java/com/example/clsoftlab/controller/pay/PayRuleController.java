package com.example.clsoftlab.controller.pay;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.clsoftlab.dto.pay.PayRuleDetailDto;
import com.example.clsoftlab.dto.pay.PayRuleListDto;
import com.example.clsoftlab.dto.pay.PayRuleRequestDto;
import com.example.clsoftlab.service.pay.PayRuleService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pay/pay-rule")
public class PayRuleController {
	
	private final PayRuleService payRuleSerivce;
	
	public PayRuleController(PayRuleService payRuleService) {
		this.payRuleSerivce = payRuleService;
	}

	
	@GetMapping("")
	public String payRuleList(@RequestParam(defaultValue = "")String itemCode, @RequestParam(defaultValue = "") String ruleType, 
			@RequestParam(defaultValue = "") String useYn, @RequestParam (required = false) Integer page, 
			Model model) {
		
		if (page == null) {
			page = 0;
		}
		int size= 1000;
		
		Page<PayRuleListDto> rulePage = payRuleSerivce.searchPayRule(itemCode, ruleType, useYn, page, size);
		
		model.addAttribute("payRule", rulePage.getContent());
		model.addAttribute("itemCode", itemCode);
		model.addAttribute("ruleType", ruleType);
		model.addAttribute("useYn", useYn);
		model.addAttribute("rulePage", rulePage);
		
		return "pay/pay-rule/list";
	}
	
	// 새 계산 규칙 추가
	@PostMapping("")
	public ResponseEntity<Void> addNewPayRule (@Valid @RequestBody PayRuleRequestDto payRule) {
		
		if(payRule.getRuleType().equals("FIXED")) {
			payRule.setFixedValue(new BigDecimal(payRule.getFormula()));
			payRule.setFormula(null);
		}
		
		payRuleSerivce.addNewPayRule(payRule);
		return ResponseEntity.ok().build();
	}
	
	// 중복 검사용
	@ResponseBody
	@GetMapping("/checkOverlap")
	public long checkOverlappingRules (@RequestParam String itemCode, @RequestParam LocalDate fromDate, 
			@RequestParam LocalDate toDate) {
		
		return payRuleSerivce.countOverlappingRules(itemCode, fromDate, toDate);
	}
	
	// 중복 검사용(수정시)
	@ResponseBody
	@GetMapping("/checkOverlap/edit")
	public long checkOverlappingRulesForUpdate (@RequestParam String itemCode, @RequestParam long ruleId ,
			@RequestParam LocalDate fromDate,@RequestParam LocalDate toDate) {
		
		return payRuleSerivce.countOverlappingRulesForUpdate(itemCode, ruleId, fromDate, toDate);
	}
	
	// 계산 규칙 detail 정보
	@GetMapping("/detail/{ruleId}")
	public ResponseEntity<PayRuleDetailDto> findPayRuleByruleId (@PathVariable long ruleId) {
		
		return payRuleSerivce.findById(ruleId)
				.map(dto -> ResponseEntity.ok(dto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{ruleId}")
	public ResponseEntity<Void> updatePayRule (@PathVariable long ruleId, @Valid @RequestBody PayRuleRequestDto dto) {
		
		if(dto.getRuleType().equals("FIXED")) {
			dto.setFixedValue(new BigDecimal(dto.getFormula()));
			dto.setFormula(null);
		}
		
		payRuleSerivce.updatePayRule(ruleId, dto);
		return ResponseEntity.ok().build();
	}
}
