package com.madras.check.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madras.check.model.dao.BlockedFileDAO;
import com.madras.check.model.vo.BlockedFile;

@Service("fService")
public class BlockedFileServiceImpl implements BlockedFileService {
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BlockedFileDAO fDAO;

	@Override
	public ArrayList<BlockedFile> selectAllCustomFile() {
		return fDAO.selectAllCustomFile(sqlSession);
	}

	@Override
	public boolean isContainedDB(BlockedFile file) {
		int result= fDAO.isContainedDB(sqlSession, file);
		if(result>0) return true;
		return false;
	}

	@Override
	public int insertBlockedFile(BlockedFile file) {
		int result=fDAO.insertBlockedFile(sqlSession, file);
		return result;
	}

	@Override
	public int deleteBlockedFile(BlockedFile file) {
		int result=fDAO.deleteBlockedFile(sqlSession, file);
		return result;
	}
	
	
	
	
}
