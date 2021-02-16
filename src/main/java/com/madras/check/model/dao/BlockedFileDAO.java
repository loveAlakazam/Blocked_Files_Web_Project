package com.madras.check.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.madras.check.model.vo.BlockedFile;

@Repository("fDAO")
public class BlockedFileDAO {

	public ArrayList<BlockedFile> selectAllCustomFile(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("fileMapper.selectAllCustomFile");
	}

	public int isContainedDB(SqlSessionTemplate sqlSession, BlockedFile file) {
		return sqlSession.selectOne("fileMapper.isContainedDB", file);
	}

	public int insertBlockedFile(SqlSessionTemplate sqlSession, BlockedFile file) {
		return sqlSession.insert("fileMapper.insertBlockedFile", file);
	}

	public int deleteBlockedFile(SqlSessionTemplate sqlSession, BlockedFile file) {
		return sqlSession.delete("fileMapper.deleteBlockedFile", file);
	}

}
