package com.uhablog.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="receipt_info")
@NoArgsConstructor
public class Receipt_infoModel {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//カラム値kirokuNum　なのだが　kioku_numで検索されてしまう
	//そのため　kirokunum (nを小文字のままにした）
	@Column(name="kirokunum")
	private int kirokuNum;
	
	@Column(name="hizuke")
	private Date hizuke;
	
	@Column(name="tempo")
	private String tempo;
	
	@Column(name="kingaku")
	private int kingaku;
	
	public Receipt_infoModel(Date hizuke,String tempo,int kingaku) {
		this.hizuke = hizuke;
		this.tempo = tempo;
		this.kingaku = kingaku;
	}
}
