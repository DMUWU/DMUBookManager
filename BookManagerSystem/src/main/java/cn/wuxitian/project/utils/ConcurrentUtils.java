package cn.wuxitian.project.utils;


import cn.wuxitian.project.model.User;
//存取当前用户
public class ConcurrentUtils {

  private static ThreadLocal<User> host = new ThreadLocal<>();

  public static User getHost(){
    return host.get();
  }

  public static void setHost(User user){
    host.set(user);
  }

}
