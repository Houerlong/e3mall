package com.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.content.service.ContentCategoryService;
import com.e3mall.mapper.TbContentCategoryMapper;
import com.e3mall.pojo.TbContentCategory;
import com.e3mall.pojo.TbContentCategoryExample;
import com.e3mall.pojo.TbContentCategoryExample.Criteria;
import com.e3mall.result.E3Result;
import com.e3mall.result.TreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper categoryMapper;
	
	public List<TreeNode> getContentCategoryList(long parentId) {
		TbContentCategoryExample example =new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = categoryMapper.selectByExample(example);
		List<TreeNode> nodes = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			TreeNode node = new TreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public E3Result addContentCategory(TbContentCategory category) {
		category.setCreated(new Date());
		category.setIsParent(false);
		//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		category.setSortOrder(1);
		//状态。可选值:1(正常),2(删除)
		category.setStatus(1);
		category.setUpdated(new Date());
		categoryMapper.insert(category);
		
		TbContentCategory tbContentCategory = categoryMapper.selectByPrimaryKey(category.getParentId());
		if (!tbContentCategory.getIsParent()) {
			tbContentCategory.setIsParent(true);
			categoryMapper.updateByPrimaryKey(tbContentCategory);
		}
		return E3Result.ok(category);
	}

}
