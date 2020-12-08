package com.jiseung.sb4.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jiseung.sb4.board.file.FileVO;
import com.jiseung.sb4.util.Pager;

public interface BoardService {
	
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;

}
