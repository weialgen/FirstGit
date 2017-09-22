package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.Items;

/**
 * 
 * @author weigen E-mail:weigen@163.com
 *
 * 2017年9月13日下午10:00:46
 */
public interface ItemService {
   
	/**
	 *查询商品列表
	 */
	public List<Items> findItemList();
	/**
	 * 根据id查询单个商品信息
	 * @param id
	 * @return
	 */
	public Items findItemById(Integer id);

}
