package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.IFightDao;
import entity.PictureInfo;
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
    
    @RequestMapping("fighting")
    public String fight(@ModelAttribute FightForm form) {
        String gameMode = form.getGameMode();
        List<PictureInfo> picInfoList = null;
        if ("Picture".equals(gameMode)) {
            picInfoList = getListPictureMode();
        }
        return "fight";
    }
    
    private List<PictureInfo> getListPictureMode() {
        // List<PictureInfo> picInfoList = fightDao.getPicInfoList();
        return null;
    }
    
    private List<Integer> getTheme() {
        return null;
    }
    
    @ModelAttribute("form")
    public FightForm getForm() {
        return new FightForm();
    }
    
}
