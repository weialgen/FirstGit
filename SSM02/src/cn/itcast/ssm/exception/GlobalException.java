package cn.itcast.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		//自定义异常信息
		String msg =null;
		//判断异常类型
		if(exception instanceof MyException){
			msg = exception.getMessage();
		}else{
		//从值栈中获取异常信息 ，保存到数据库中,发短信或者是邮件，告诉维护人员
		msg= new String("系统繁忙，请稍后从试。。。。");
		}
		//返回页面，加数据
		ModelAndView view = new ModelAndView();
		view.addObject("message", msg);
		view.setViewName("error");
		return view;
	}

}
