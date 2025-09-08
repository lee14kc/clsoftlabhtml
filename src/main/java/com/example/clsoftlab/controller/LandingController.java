package com.example.clsoftlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*

프로그램명 : Landing Controller

작성자 : 양한재

작성일 : 2025-09-08

수정자 : 

수정일 : 

프로그램 개요 : Landing Controller는 랜딩 페이지를 처리하는 컨트롤러 클래스이다.

프로그램 설명 : 초기 접속시 사용자에게 보여줄 랜딩 페이지를 매핑한다.

랜딩 페이지는 현재 navbar 테스트, 임시용입니다.

*/

@Controller
public class LandingController {

	@GetMapping("/")
	public String landingPage() {
		return "test";
	}
}
