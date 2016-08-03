package controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    
    @ExceptionHandler(Exception.class)
    public String ExceptionHandle(Exception ex, Model model){
    	model.addAttribute("message", ex.getMessage());
    	return "error";
    }
    
    @RequestMapping("fight")
    public String fight(@ModelAttribute FightForm form, Model model) throws Exception {
        String gameMode = form.getGameMode();
        List<PictureInfo> picInfoList = null;
        if ("Picture".equals(gameMode)) {
            picInfoList = getListPictureForPictureMode();
        }
        model.addAttribute("picInfoList", picInfoList);
        model.addAttribute("question", "AAAAAAA");
        return "fight";
    }
    
    private List<PictureInfo> getListPictureForPictureMode() throws Exception {
        FightParam param = new FightParam();
        //param.setThemeId(getTheme().getThemeId());
        param.setThemeId(1);
        List<PictureInfo> picInfoList = null;
        try {
        	picInfoList = fightDao.getPicInfoList(param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(picInfoList != null){
        	Collections.shuffle(picInfoList);
        	while(picInfoList.size() > 9){
        		picInfoList.remove(0);
        	}
        }else{
        	throw new Exception("List null");
        }
        return picInfoList;
    }
    
    private Theme getTheme() throws Exception {
        List<Theme> themeList;
        try {
            themeList = fightDao.getAllTheme();
            Random rd = new Random();
            return themeList.get(rd.nextInt(themeList.size()));
        } catch (SQLException e) {
        	e.printStackTrace();
        	throw new Exception("SQL Exception");
        }
    }
    
    @ModelAttribute("form")
    public FightForm getForm() {
        return new FightForm();
    }
    
}
