package com.jiseung.sb4.member;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jiseung.sb4.board.file.FileVO;
import com.jiseung.sb4.util.FileManager;
import com.jiseung.sb4.util.FilePathGenerator;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	@Value("${member.filePath}")
	private String filePath;
	
	
	public int setInsert(MemberVO memberVO, MultipartFile [] files) throws Exception{
		
		int result = memberMapper.setInsert(memberVO);
		
		//1. HDD에 File 저장
		//-- 저장할 폴더의 실제 경로명
		File file = filePathGenerator.getUseResourceLoader(this.filePath); // 저장할 폴더명 -> properties 파일에 적어둠
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			System.out.println(fileName);
			
			MemberFileVO memberFileVO = new MemberFileVO();
			memberFileVO.setFileName(fileName);
			memberFileVO.setOriName(multipartFile.getOriginalFilename());
			memberFileVO.setId(memberVO.getId());
			
	        //하드디스크랑 데이터베이스 둘다 들어감
	        result = memberMapper.setInsertFile(memberFileVO);

		}
		
		return result;
	}
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getMemberLogin(memberVO);
	}

}
