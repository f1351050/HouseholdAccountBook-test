package com.uhablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.uhablog.model.Receipt_infoModel;
import com.uhablog.processor.Receipt_infoExtraction;
import com.uhablog.service.Receipt_infoService;

@Controller
public class Rceipt_infoController {

	@Autowired
	Receipt_infoService service;
	
	@Autowired
	Receipt_infoExtraction extraction;
	
	@GetMapping("receipt_infoList")
	public String getReceipt_infoList(Model model) {
		
		List<Receipt_infoModel> receipt_infoList = service.findAll();
		model.addAttribute("receipt_infoList",receipt_infoList);
		return "receipt_infoList";
	}
	
	@PostMapping("/receipt_infoList")
	public String postReceipt_infoList(Model model) {
		
		extraction.process();
		
		return "receipt_infoList";
	}
	
	
}
