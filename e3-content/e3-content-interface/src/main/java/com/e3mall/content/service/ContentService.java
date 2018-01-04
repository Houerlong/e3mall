package com.e3mall.content.service;

import com.e3mall.pojo.TbContent;
import com.e3mall.result.DatagridResult;
import com.e3mall.result.E3Result;

public interface ContentService {
	public DatagridResult getContentList(long categoryId,int page,int rows);
	public E3Result addContent(TbContent content);
}
