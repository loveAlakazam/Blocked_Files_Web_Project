package com.madras.check.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.madras.check.model.service.BlockedFileService;
import com.madras.check.model.vo.BlockedFile;

@Controller
public class BlockedFileController {
	@Autowired
	private BlockedFileService fService;
	
	
	@RequestMapping("insertBlockedFile.fi")
	@ResponseBody
	public void insertBlockedFile(BlockedFile file, HttpServletResponse response) throws JsonIOException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		String msg="위험 파일 확장자 등록을 성공하였습니다.";
		
		//입력한 확장자 이름이 데이터베이스에 존재하는지 확인
		boolean isContained = fService.isContainedDB(file);
		
		if(isContained) {
			msg="이미 존재하는 위험 파일 확장자 입니다.";
		}else {
			//등록한다.
			int insertResult= fService.insertBlockedFile(file);
			if(insertResult==0) {
				msg="위험 파일 확장자 등록을 실패하였습니다.";
			}
		}
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(msg, response.getWriter());
	}
	
	@RequestMapping("deleteBlockedFile.fi")
	@ResponseBody
	public void deleteBlockedFile(BlockedFile file, HttpServletResponse response) throws JsonIOException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		String msg="성공적으로 삭제되었습니다.";
		
		int deleteResult= fService.deleteBlockedFile(file);
		if(deleteResult==0)
			msg="삭제에 실패하였습니다.";
		Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(msg, response.getWriter());
	}

}
