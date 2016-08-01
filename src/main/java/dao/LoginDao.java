package dao;

import java.sql.SQLException;
import java.util.List;

import entity.UserInfo;



public interface LoginDao {
    public List<UserInfo> checkLogin(String username) throws SQLException;
}
