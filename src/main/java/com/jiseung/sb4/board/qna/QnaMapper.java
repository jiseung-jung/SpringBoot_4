package com.jiseung.sb4.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.jiseung.sb4.board.BoardMapper;

@Mapper
public interface QnaMapper extends BoardMapper {
	
	public int setRefUpdate(QnaVO qnaVO) throws Exception;

}
