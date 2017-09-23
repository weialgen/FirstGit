package cn.itcast.ssm.pojo;

import java.util.List;

/**
 * 
 * @author weigen E-mail:weigen@163.com
 *
 * 2017年9月14日上午9:53:30
 */
public class QueryVo {
   
	private Items items;
	private User user;
    private Integer[]ids;
    private List<Items>itemList;
	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
