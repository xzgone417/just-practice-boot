package com.exp.ucmp.file.dto;

import com.egrid.core.base.model.BaseModel;


public class FileReturnDto extends BaseModel {

	private static final long serialVersionUID = 1641470333725504316L;

	/**
     * 文件id
     */
    private Long fileId;

    /**
     * 缩略图
     */
    private String thumbnailFile;

    public FileReturnDto(Long fileId,String thumbnailFile){
		this.fileId = fileId;
		this.thumbnailFile = thumbnailFile;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getThumbnailFile() {
		return thumbnailFile;
	}

	public void setThumbnailFile(String thumbnailFile) {
		this.thumbnailFile = thumbnailFile;
	}
}
