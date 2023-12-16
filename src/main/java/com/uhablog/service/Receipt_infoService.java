package com.uhablog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhablog.model.Receipt_infoModel;
import com.uhablog.repository.Receipt_infoRepository;


@Service
@Transactional
public class Receipt_infoService {
	
	@Autowired
	Receipt_infoRepository repository;
	
	 /**
     * データベースから本の一覧を取得する
     * @return
	 */
	
	public List<Receipt_infoModel> findAll(){
		return repository.findAll();
	}

}
