package com.jiseung.sb4.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jiseung.sb4.board.file.FileVO;
import com.jiseung.sb4.util.FileManager;
import com.jiseung.sb4.util.FilePathGenerator;
import com.jiseung.sb4.board.BoardService;
import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	@Value("${board.qna.filePath}")
	private String filePath;

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		int result = qnaMapper.setInsert(boardVO);
		System.out.println("Num:" + boardVO.getNum());
		
		//1. HDD에 File 저장
		//-- 저장할 폴더의 실제 경로명
		File file = filePathGenerator.getUseResourceLoader(this.filePath); // 저장할 폴더명 -> properties 파일에 적어둠
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			System.out.println(fileName);
			
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartFile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
			
	        //하드디스크랑 데이터베이스 둘다 들어감
	        result = qnaMapper.setInsertFile(fileVO);

		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		long totalCount = qnaMapper.getCount(pager);
		pager.makePage(totalCount);
		
		return qnaMapper.getList(pager);
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
