package top.vertical.service;

import top.vertical.pojo.User;

public interface WxService {
  User getAuthCode2Session(User user) throws Exception;
}
