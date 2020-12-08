package com.jiseung.sb4.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jiseung.sb4.board.BoardService;
import com.jiseung.sb4.board.BoardVO;
import com.jiseung.sb4.board.file.FileVO;
import com.jiseung.sb4.util.FileManager;
import com.jiseung.sb4.util.FilePathGenerator;
import com.jiseung.sb4.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	@Value("${board.notice.filePath}")
	private String filePath;
	
	


	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		long totalCount = noticeMapper.getCount(pager);
		pager.makePage(totalCount);
		
		return noticeMapper.getList(pager);
	}

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		int result = noticeMapper.setInsert(boardVO);
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
			//fileVO.setNum(2000); --> 에러 발생용
			
	        //하드디스크랑 데이터베이스 둘다 들어감
	        result = noticeMapper.setInsertFile(fileVO);

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
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return noticeMapper.getOne(boardVO);
	}

	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getFile(fileVO);
	}
	
	
	
	
	

}
