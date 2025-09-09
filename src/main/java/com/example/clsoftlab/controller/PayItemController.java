package com.example.clsoftlab.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clsoftlab.dto.PayItemListDto;
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
		int size= 10;
		
		Page<PayItemListDto> itemPage = payItemService.searchPayItem(itemName, itemType, useYn, page, size);
		
		model.addAttribute("payItem", itemPage.getContent());
		model.addAttribute("itemName", itemName);
		model.addAttribute("itemType", itemType);
		model.addAttribute("useYn", useYn);
		model.addAttribute("itemPage", itemPage);
		
		return "pay/pay-item/list";
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
