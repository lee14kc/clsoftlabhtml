package com.example.clsoftlab.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.clsoftlab.dto.PayItemListDto;
import com.example.clsoftlab.repository.PayItemRepository;

@Service
public class PayItemService {

	private final PayItemRepository payItemRepository;
	private final ModelMapper modelMapper;
	
	public PayItemService(PayItemRepository payItemRepository, ModelMapper modelMapper) {
		this.payItemRepository = payItemRepository;
		this.modelMapper = modelMapper;
	}
	
	
	// 급여 항목 목록 검색
	public Page<PayItemListDto> searchPayItem(String itemName, String itemType, String useYn, int page, int size) {
	
		Pageable pageable = PageRequest.of(page, size, Sort.by("itemName"));
		return payItemRepository.search(itemName, itemType, useYn, pageable).map(i -> modelMapper.map(i, PayItemListDto.class));
	}
}
