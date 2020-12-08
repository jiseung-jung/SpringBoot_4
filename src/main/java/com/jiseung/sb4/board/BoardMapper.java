package com.jiseung.sb4.board;

import java.util.List;

import com.jiseung.sb4.board.file.FileVO;
import com.jiseung.sb4.board.notice.NoticeVO;
import com.jiseung.sb4.util.Pager;

public interface BoardMapper {
	
	public int setInsert(BoardVO boardVO) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public long getCount(Pager pager) throws Exception;
	
	
	// file==------------------------------------------------
	
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;
	

}
