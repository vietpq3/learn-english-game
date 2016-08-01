package daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AbstractDao;
import dao.IFightDao;
import entity.PictureInfo;

public class FightDaoImpl extends AbstractDao implements IFightDao {
    
    @Autowired
    public FightDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    
    @Override
    public List<PictureInfo> getPicInfoList() {
        return null;
    }
    
}
