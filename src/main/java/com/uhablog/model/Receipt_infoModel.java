package com.uhablog.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="receipt_info")
public class Receipt_infoModel {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kirokunum")
	private Integer kirokuNum;
	
	@Column(name="hizuke")
	private Date hizuke;
	
	@Column(name="tempo")
	private String tempo;
	
	@Column(name="kingaku")
	private String kingaku;
}
