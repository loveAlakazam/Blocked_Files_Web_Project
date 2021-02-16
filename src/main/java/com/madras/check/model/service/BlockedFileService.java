package com.madras.check.model.service;

import java.util.ArrayList;

import com.madras.check.model.vo.BlockedFile;

public interface BlockedFileService {

	ArrayList<BlockedFile> selectAllCustomFile();

	boolean isContainedDB(BlockedFile file);

	int insertBlockedFile(BlockedFile file);

	int deleteBlockedFile(BlockedFile file);

}
