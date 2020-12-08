package com.jiseung.sb4.board;

import java.sql.Date;
import java.util.List;

import com.jiseung.sb4.board.file.FileVO;

import lombok.Data;

@Data
public class BoardVO {
	
	private long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private long hit;
	

}
