package com.e3mall.content.service;

import java.util.List;

import com.e3mall.pojo.TbContentCategory;
import com.e3mall.result.E3Result;
import com.e3mall.result.TreeNode;

public interface ContentCategoryService {
	public List<TreeNode> getContentCategoryList(long parentId);
	public E3Result addContentCategory(TbContentCategory category);
}
