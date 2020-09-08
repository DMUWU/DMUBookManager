package cn.wuxitian.project.service;

import cn.wuxitian.project.model.User;
import cn.wuxitian.project.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;


@Service
public class HostHolder {

  public User getUser() {
    return ConcurrentUtils.getHost();
  }

  public void setUser(User user) {
    ConcurrentUtils.setHost(user);
  }
}
