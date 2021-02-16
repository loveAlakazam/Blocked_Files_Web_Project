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
		String msg="���� ���� Ȯ���� ����� �����Ͽ����ϴ�.";
		
		//�Է��� Ȯ���� �̸��� �����ͺ��̽��� �����ϴ��� Ȯ��
		boolean isContained = fService.isContainedDB(file);
		
		if(isContained) {
			msg="�̹� �����ϴ� ���� ���� Ȯ���� �Դϴ�.";
		}else {
			//����Ѵ�.
			int insertResult= fService.insertBlockedFile(file);
			if(insertResult==0) {
				msg="���� ���� Ȯ���� ����� �����Ͽ����ϴ�.";
			}
		}
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(msg, response.getWriter());
	}
	
	@RequestMapping("deleteBlockedFile.fi")
	@ResponseBody
	public void deleteBlockedFile(BlockedFile file, HttpServletResponse response) throws JsonIOException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		String msg="���������� �����Ǿ����ϴ�.";
		
		int deleteResult= fService.deleteBlockedFile(file);
		if(deleteResult==0)
			msg="������ �����Ͽ����ϴ�.";
		Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(msg, response.getWriter());
	}

}
