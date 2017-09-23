package cn.itcast.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.exception.MyException;
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
@RequestMapping("item")
public class ItemController {
    
	@Autowired
	private ItemService itemService;
	@RequestMapping(value={"itemList","itemListFindAll"},method=RequestMethod.GET)
	public ModelAndView itemList() throws MyException{
		/*// 自定义异常
		if (true) {
			throw new MyException("自定义异常出现了~");
		}
		// 运行时异常
		int i = 1/0;*/
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
    public ModelAndView itemEdit( HttpServletRequest request){
    	//获取页面提交过来的id
    	String id = request.getParameter("id");
    	//获取商品数据
    	Items items = itemService.findItemById(Integer.parseInt(id));
    	//Items items = itemService.findItemById(id);
    	//创建模型视图对象
    	ModelAndView modelAndView = new ModelAndView();
    	//把商品数据放到模型中
    	modelAndView.addObject("items", items);
    	//设置逻辑视图
    	modelAndView.setViewName("editItem");
    	return modelAndView;
    }
    @RequestMapping("updateItem")
    public String updateItem(Items items,MultipartFile pictureFile) throws Exception{
        //图片上传 设置图片名称，不可重复，用UUID
    	String picName = UUID.randomUUID().toString();
    	//获取文件名
    	String fileName = pictureFile.getOriginalFilename();
    	//获取图片后缀
    	String suffName = fileName.substring(fileName.lastIndexOf("."));
    	//上传照片
    	pictureFile.transferTo(new File("D:/javaEE"+picName+suffName));
    	//设置图片名到商品中
    	items.setPic(picName+suffName);
    	//更新商品
    	itemService.updateItemById(items);
    	return "forward:/item/itemEdit.action";
    }
    @RequestMapping("queryitem")
    public String queryitem(QueryVo vo,Integer[]ids){
    	System.out.println(vo.getItems().getName()+vo.getUser().getUsername());
    	return null;
    }
    @RequestMapping("updateItems")
	public String updateItems(QueryVo vo){
		return "success";
	}
    @RequestMapping("queryItem")
    public void queryItem(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
    	//response.sendRedirect("itemList.action");
    	//response.getWriter().print("{\"abc\":123}");  	
    	response.getWriter().print("{'abc':123456}");  	
    }
    @RequestMapping("findItem")
    public String findItem(){
    	//return "success";
    	//重定向
    	//return "redirect:/item/itemList.action";
    	//请求转发
    	return "forward:/WEB-INF/jsp/success.jsp";
    }
    @RequestMapping("requestJson")
    @ResponseBody
    public Items requestJson( @RequestBody Items items){
    	return items;
    			
    }
}
