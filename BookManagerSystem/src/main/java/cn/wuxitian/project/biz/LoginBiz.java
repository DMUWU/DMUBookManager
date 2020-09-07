package cn.wuxitian.project.biz;

//import com.nowcoder.project.model.Ticket;
import cn.wuxitian.project.model.User;
//import com.nowcoder.project.model.exceptions.LoginRegisterException;
//import com.nowcoder.project.service.TicketService;
import cn.wuxitian.project.service.UserService;
//import com.nowcoder.project.utils.ConcurrentUtils;
import cn.wuxitian.project.utils.MD5;
//import com.nowcoder.project.utils.TicketUtils;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBiz {
	@Autowired
	private UserService userService;


//	    private TicketService ticketService;

	/**
	 * 登录逻辑，先检查邮箱和密码，然后更新t票。
	 * 
	 * @return 返回最新t票
	 * @throws Exception 账号密码错误
	 */
	public String login(String email, String password) throws Exception {
		System.out.println("login");
		User user = userService.getUser(email);
		System.out.println(user);
		// 登录信息检查
		if (user == null)
//			throw new LoginRegisterException("邮箱不存在");
			throw new Exception("邮箱不存在");
		if (!StringUtils.equals(MD5.next(password), user.getPassword()))
//			throw new LoginRegisterException("密码不正确");
			throw new Exception("密码不正确");
		
		return "login/login";
	}
	
	
	public String register(User user) throws Exception {

	    //信息检查
	    if (userService.getUser(user.getEmail()) != null) {
	      throw new Exception("用户邮箱已经存在！");
	    }

	    //密码加密
	    String plain = user.getPassword();
	    String md5 = MD5.next(plain);
	    user.setPassword(md5);
	    //数据库添加用户
	    userService.addUser(user);


	    return "chenggongt";

	  }
	
}
