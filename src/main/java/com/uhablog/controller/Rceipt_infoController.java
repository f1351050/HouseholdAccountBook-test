package com.uhablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uhablog.model.Receipt_infoModel;
import com.uhablog.service.Receipt_infoService;

@Controller
public class Rceipt_infoController {

	@Autowired
	Receipt_infoService service;
	
	@GetMapping("receipt_infoList")
	public String receipt_infoList(Model model) {
		
		List<Receipt_infoModel> receipt_infoList = service.findAll();
		model.addAttribute("receipt_infoList",receipt_infoList);
		return "receipt_infoList";
	}
	
}
