package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import param.FightParam;
import dao.IFightDao;
import entity.PictureInfo;
import entity.Theme;
import form.FightForm;

@Controller
@RequestMapping("fight")
public class FightController {
    
    @Autowired
    private IFightDao fightDao;
    
    @RequestMapping("index")
    public String index() {
        return "fight";
    }
    
    @RequestMapping("fight")
    public String fight(@ModelAttribute FightForm form) {
        String gameMode = form.getGameMode();
        List<PictureInfo> picInfoList = null;
        if ("Picture".equals(gameMode)) {
            picInfoList = getListPictureMode();
        }
        return "fight";
    }
    
    private List<PictureInfo> getListPictureMode() {
        FightParam param = new FightParam();
        param.setThemeId(getTheme().getThemeId());
        try {
            List<PictureInfo> picInfoList = fightDao.getPicInfoList(param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Theme getTheme() {
        List<Theme> themeList;
        try {
            themeList = fightDao.getAllTheme();
            Random rd = new Random();
            return themeList.get(rd.nextInt(themeList.size()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @ModelAttribute("form")
    public FightForm getForm() {
        return new FightForm();
    }
    
}
