package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import dao.LoginDao;
import entity.UserInfo;

@Component
public class LoginDaoImpl implements LoginDao {
    
    private DataSource datasource;
    
    public void setDataSource(DataSource datasource) {
        this.datasource = datasource;
    }
    
    public List<UserInfo> checkLogin(String username) throws SQLException {
        Connection con = datasource.getConnection();
        Statement stm = con.createStatement();
        String sql = "select * from loginInf where username = " + username;
        ResultSet rs = stm.executeQuery(sql);
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfo userInfo = null;
        while (rs.next()) {
            userInfo = new UserInfo();
            userInfo.setUsername(rs.getString("username"));
            userInfo.setPassword(rs.getString("passwords"));
            userInfoList.add(userInfo);
        }
        return userInfoList;
    }
    
}
