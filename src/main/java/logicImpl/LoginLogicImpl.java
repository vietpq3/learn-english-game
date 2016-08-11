package logicImpl;

import java.sql.SQLException;
import java.util.List;

import logic.ILoginLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import param.LoginParam;
import dao.ILoginDao;
import entity.UserInfo;

@Component
public class LoginLogicImpl implements ILoginLogic {

    @Autowired
    private ILoginDao loginDao;

    @Override
    public List<UserInfo> checkLogin(LoginParam param) throws SQLException {
        return loginDao.checkLogin(param);
    }

    @Override
    public int registerAccount(LoginParam param) throws SQLException {
        return loginDao.registerAccount(param);
    }
}
