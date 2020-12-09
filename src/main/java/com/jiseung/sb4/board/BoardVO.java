package com.jiseung.sb4.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BoardVO {
	
	private long num;
	@NotEmpty
	private String title;
	@NotEmpty
	private String writer;
	private String contents;
	private Date regDate;
	private long hit;
	

}
