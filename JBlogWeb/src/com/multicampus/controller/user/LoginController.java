package com.multicampus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.blog.BlogService;
import com.multicampus.biz.blog.BlogVO;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;

	@RequestMapping("/login.do")
	public String login(UserVO userVo, BlogVO blogVo, HttpSession session) {
		UserVO user = userService.getUser(userVo);
		if (user != null) {
			// �α��� ���� ��, ���ǿ� user ���� ����
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userRole", user.getRole());
			
			// �α��� ������ ����ڰ� ��α׸� �����ߴٸ�, ������� ��α� ������ ���ǿ� ����
			blogVo.setBlogId(user.getUserId());
			BlogVO blog = blogService.getBlog(blogVo);
			if (blog != null) {
				session.setAttribute("blog", blog);
			}
		}
		return "index.jsp";
	}
}
