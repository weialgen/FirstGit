package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Items;
import cn.itcast.ssm.pojo.QueryVo;
import cn.itcast.ssm.service.ItemService;

/**
 * 
 * @author weigen E-mail:weigen@163.com
 *
 * 2017年9月13日下午10:28:49
 */
@Controller
public class ItemController {
    
	@Autowired
	private ItemService itemService;
	@RequestMapping("itemList")
	public ModelAndView itemList(){
		//获取商品数据
		List<Items> list = itemService.findItemList();
		//创建模型视图对象
		ModelAndView modelAndView = new ModelAndView();
		//把商品数据放在模型中
		modelAndView.addObject("itemList", list);
		//设置逻辑视图
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
    @RequestMapping("itemEdit")
    public ModelAndView itemEdit(HttpServletRequest request){
    	//获取页面提交过来的id
    	String id = request.getParameter("id");
    	//获取商品数据
    	Items items = itemService.findItemById(Integer.parseInt(id));
    	//创建模型视图对象
    	ModelAndView modelAndView = new ModelAndView();
    	//把商品数据放到模型中
    	modelAndView.addObject("items", items);
    	//设置逻辑视图
    	modelAndView.setViewName("editItem");
    	return modelAndView;
    }
    @RequestMapping("updateItem")
    public ModelAndView updateItem(Items items){
    	System.out.println("name="+items.getName());
    	return null;
    }
    @RequestMapping("queryitem")
    public String queryitem(QueryVo vo){
    	System.out.println(vo.getItems().getName()+vo.getUser().getUsername());
    	return null;
    }
}
