package com.bizoe.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bizoe.util.DateUtils;

/**
 * @author wangxinxin
 */
@Controller
@RequestMapping("/web")
public class WebController {
	
	@RequestMapping("/hi")
	public String hi(Map<String, Object> model) {
		model.put("time", DateUtils.nowToString());
		model.put("message", "这是测试的内容。。。");
		model.put("toUserName", "张三");
		model.put("fromUserName", "老王");
		//自动寻找resources/templates中名字为welcome.ftl/welcome.vm的文件作为模板，拼装后返回
		return "welcome";
	}
}
