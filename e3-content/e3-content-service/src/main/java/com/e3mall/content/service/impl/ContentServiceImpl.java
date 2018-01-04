package com.e3mall.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.content.service.ContentService;
import com.e3mall.mapper.TbContentMapper;
import com.e3mall.pojo.TbContent;
import com.e3mall.pojo.TbContentExample;
import com.e3mall.pojo.TbContentExample.Criteria;
import com.e3mall.result.DatagridResult;
import com.e3mall.result.E3Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;
	
	public DatagridResult getContentList(long categoryId, int page, int rows) {
		PageHelper.startPage(page, rows);
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = contentMapper.selectByExample(example );
		PageInfo<TbContent> info = new PageInfo<>(list);
		long total = info.getTotal();
		DatagridResult datagridResult = new DatagridResult();
		datagridResult.setTotal((int) total);
		datagridResult.setRows(list);
		return datagridResult;
	}

	@Override
	public E3Result addContent(TbContent content) {
		
		
		
		
		return null;
	}

}
