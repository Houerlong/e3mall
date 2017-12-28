package com.e3mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.service.TbItemService;

@Service
public class TbItemServiceImpl implements TbItemService {

	@Autowired
	private TbItemMapper itemMapper;
	public TbItem getTbItemById(long id) {
		TbItem item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

}
