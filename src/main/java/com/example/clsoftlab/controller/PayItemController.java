package com.example.clsoftlab.controller;

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

import com.example.clsoftlab.dto.PayItemDetailDto;
import com.example.clsoftlab.dto.PayItemListDto;
import com.example.clsoftlab.dto.PayItemRequestDto;
import com.example.clsoftlab.service.PayItemService;

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
	
	private final PayItemService payItemService;
	
	public PayItemController(PayItemService payItemService) {
		this.payItemService = payItemService;
	}
	
	@GetMapping("")
	public String payItemList(@RequestParam(defaultValue = "") String itemName, @RequestParam(defaultValue = "") String itemType,
			@RequestParam(defaultValue = "") String useYn, @RequestParam(required = false) Integer page,
			Model model) { 
		
		
		if (page == null) {
			page = 0;
		}
		int size= 1000;
		
		Page<PayItemListDto> itemPage = payItemService.searchPayItem(itemName, itemType, useYn, page, size);
		
		model.addAttribute("payItem", itemPage.getContent());
		model.addAttribute("itemName", itemName);
		model.addAttribute("itemType", itemType);
		model.addAttribute("useYn", useYn);
		model.addAttribute("itemPage", itemPage);
		
		return "pay/pay-item/list";
	}
	
	//급여 항목 추가
	@PostMapping("")
	public ResponseEntity<Void> addNewPayItem (@RequestBody PayItemRequestDto payItem) {
		
		payItemService.addNewPayItem(payItem);
		return ResponseEntity.ok().build();
	}
	
	// itemCode로 급여항목 검색
	@GetMapping("/{itemCode}")
    public ResponseEntity<PayItemDetailDto> findPayItemByCode(@PathVariable String itemCode) {
        
		System.out.println(itemCode);
		return payItemService.findByCode(itemCode)
                .map(dto -> ResponseEntity.ok(dto)) 
                .orElse(ResponseEntity.notFound().build());
   }
	
	//급여 항목 수정
	@PutMapping("/{itemCode}")
	public ResponseEntity<Void> updatePayItem(@PathVariable String itemCode, @RequestBody PayItemRequestDto payItem) {
	    // itemCode와 DTO를 서비스 계층으로 넘겨 수정 로직을 수행합니다.
	    payItemService.updatePayItem(itemCode, payItem);
	    return ResponseEntity.ok().build();
	}

    @GetMapping("test")
    public String payItemTestList(@RequestParam(defaultValue = "") String itemName, @RequestParam(defaultValue = "") String itemType,
                              @RequestParam(defaultValue = "") String useYn, @RequestParam(required = false) Integer page,
                              Model model) {


        if (page == null) {
            page = 0;
        }
        int size= 1000; //필요한 경우만 사용 가능하도록 변경 필요 size가 0일때는 전체 나오도록 개선 필요.

        Page<PayItemListDto> itemPage = payItemService.searchPayItem(itemName, itemType, useYn, page, size);

        model.addAttribute("payItem", itemPage.getContent());
        model.addAttribute("itemName", itemName);
        model.addAttribute("itemType", itemType);
        model.addAttribute("useYn", useYn);
        model.addAttribute("itemPage", itemPage);

        return "pay/pay-item/list_backup";
    }
}
