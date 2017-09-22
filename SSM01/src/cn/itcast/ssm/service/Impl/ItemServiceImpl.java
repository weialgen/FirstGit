package cn.itcast.ssm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.pojo.Items;
import cn.itcast.ssm.service.ItemService;
@Service
public  class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
	@Override
	public List<Items> findItemList() {
		List<Items> list = itemsMapper.selectByExample(null);
		return list;
	}
	@Override
	public Items findItemById(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

}
