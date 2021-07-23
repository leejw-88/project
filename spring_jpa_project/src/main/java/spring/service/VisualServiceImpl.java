package spring.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import spring.domain.dto.VisualDto;
import spring.domain.repository.VisualEntityRepository;

@Service
public class VisualServiceImpl implements VisualService {
	@Autowired
	private VisualEntityRepository visualEntityRepository;
	
	//업로드후 DB저장
	@Override
	public void uploadAndSave(VisualDto dto, MultipartFile file) {
		long fileSize=file.getSize();// 2*1024*1024
		if(fileSize > (2*1024*1024)) {
			//System.out.println("파일용량제한:2mb");
			return;
		}
		//1. file upload
		String fileName=file.getOriginalFilename();
		String fileUrl="/images/visual/";

		//E:~~~~~~~~~~~/images/visual/ 물리경로지정
		ClassPathResource cpr=new ClassPathResource("static"+fileUrl);//바이너리 저장
		try {
			File location=cpr.getFile();
			//System.out.println("location: "+location);
			file.transferTo(new File(location, fileName));//업로드
			System.out.println("파일업로드 완료"+location +fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dto.setFileName(fileName);
		dto.setFileSize(fileSize);
		dto.setFileUrl(fileUrl);
		//2. save
		visualEntityRepository.save(dto.toEntity());
	}

	@Override
	public void getList(Model model) {
		model.addAttribute("list",visualEntityRepository.findAll()
				.stream()
				.map(VisualDto::new)
				.collect(Collectors.toList()));
	}
	//임시파일 업로드
	@Override
	public String uploadByTemp(MultipartFile tempFile) {
		long fileSize=tempFile.getSize();// 2*1024*1024
		if(fileSize > (2*1024*1024)) {
			//System.out.println("파일용량제한:2mb");
			return null;
		}
		//1. file upload
		String fileName=tempFile.getOriginalFilename();
		String fileUrl="/images/visual/temp/";
		ClassPathResource cpr=new ClassPathResource("static"+fileUrl);
		try {
			
			File tempLocation=cpr.getFile();
			
			//기존파일 제거
			for(File temp:tempLocation.listFiles()) {
				//if(temp.isFile())temp.delete();//파일만제거
				temp.delete();// 파일 폴더 모두제거
				//System.out.println(temp);
			}
			System.out.println("------------- temp폴더 -----------------");
			//삭제
			
			//업로드
			tempFile.transferTo(new File(tempLocation, fileName));//업로드
			System.out.println("임시파일업로드");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUrl+fileName;
		}
	//임시파일 업로드된것 경로이동저장
	@Override
	public void uploadAndSave2(VisualDto dto, MultipartFile file) {
		//1. file upload
		long fileSize=file.getSize();// 2*1024*1024
		String fileName=file.getOriginalFilename();
		String fileUrl="/images/visual/";
		ClassPathResource cpr=new ClassPathResource("static"+fileUrl);
		
		ClassPathResource tempcpr=new ClassPathResource("static"+fileUrl+"temp/");
		try {
			File tempFolder=tempcpr.getFile();
			File tempFile=new File(tempFolder,fileName);
			if(tempFile.exists()) {
				//존재하면 파일이동
				tempFile.renameTo(new File(cpr.getFile(),fileName));
				System.out.println("임시파일->visual경로로 이동");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		dto.setFileName(fileName);
		dto.setFileSize(fileSize);
		dto.setFileUrl(fileUrl);
		//2. save
		visualEntityRepository.save(dto.toEntity());
	}

}
