package controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import param.FightParam;

import common.CryptUtil;

import dao.IFightDao;
import entity.PictureInfo;
import entity.Theme;
import exception.SystemException;
import form.FightForm;

@Controller
@RequestMapping("fight")
public class FightController {
    
    @Autowired
    private IFightDao fightDao;
    
    @ExceptionHandler(SystemException.class)
    public ModelAndView SystemExceptionHandle(SystemException ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", ex.getMessage());
        return mav;
    }
    
    @RequestMapping("index")
    public String index() {
        return "fight";
    }
    
    @RequestMapping("fight")
    public String fight(@ModelAttribute FightForm form, Model model,
            HttpServletRequest request) throws Exception {
        String gameMode = form.getGameMode();
        List<PictureInfo> picInfoList = null;
        List<String> alreadyUseQuestionList = new ArrayList<String>();
        if ("Picture".equals(gameMode)) {
            picInfoList = getListPictureForPictureMode();
        }
        if (picInfoList == null || picInfoList.isEmpty()) {
            throw new SystemException("Can not get List picture");
        }
        encryptPictureName(picInfoList, request.getSession().getId());
        String question = getQuestion(picInfoList, alreadyUseQuestionList);
        alreadyUseQuestionList.add(question);
        
        form.setPicInfoList(picInfoList);
        model.addAttribute("picInfoList", picInfoList);
        model.addAttribute("alreadyUseQuestionList", alreadyUseQuestionList);
        model.addAttribute("question", question);
        return "fight";
    }
    
    @RequestMapping("fighting")
    public String fighting(@ModelAttribute FightForm form, Model model,
            HttpServletRequest request) throws SystemException {
        String answer = form.getAnswer();
        String question = form.getQuestion();
        List<PictureInfo> picInfoList = form.getPicInfoList();
        List<String> alreadyUseQuestionList = form.getAlreadyUseQuestionList();
        try {
            if (question.equals(CryptUtil.decrypt(answer, request.getSession()
                    .getId()))) {
                if (picInfoList.size() == alreadyUseQuestionList.size()) {
                    return "redirect:fight/fight";
                }
                question = getQuestion(picInfoList, alreadyUseQuestionList);
                alreadyUseQuestionList.add(question);
            }
        } catch (UnsupportedEncodingException e) {
            throw new SystemException("Encrypt/Decrypt fail");
        }
        form.setPicInfoList(picInfoList);
        // model.addAttribute("picInfoList", picInfoList);
        model.addAttribute("alreadyUseQuestionList", alreadyUseQuestionList);
        model.addAttribute("question", question);
        return "fight";
    }
    
    private List<PictureInfo> encryptPictureName(List<PictureInfo> picInfoList,
            String sessionId) throws UnsupportedEncodingException {
        for (PictureInfo picInfo : picInfoList) {
            picInfo.setEncryptPictureName(CryptUtil.encrypt(
                    picInfo.getPictureName(), sessionId));
        }
        return picInfoList;
    }
    
    private String getQuestion(List<PictureInfo> picInfoList,
            List<String> alreadyUseQuestionList) {
        Random rd = new Random();
        Collections.shuffle(picInfoList);
        String question = picInfoList.get(0).getPictureName();
        do {
            question = picInfoList.get(rd.nextInt(picInfoList.size() - 1))
                    .getPictureName();
        } while (alreadyUseQuestionList.contains(question));
        
        return question;
    }
    
    private List<PictureInfo> getListPictureForPictureMode() throws Exception {
        FightParam param = new FightParam();
        // param.setThemeId(getTheme().getThemeId());
        param.setThemeId(1);
        List<PictureInfo> picInfoList = null;
        try {
            picInfoList = fightDao.getPicInfoList(param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (picInfoList != null && picInfoList.size() > 0) {
            Collections.shuffle(picInfoList);
            while (picInfoList.size() > 9) {
                picInfoList.remove(0);
            }
        } else {
            throw new SystemException("List empty");
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
            throw new SystemException("SQL Exception");
        }
    }
    
    @ModelAttribute("form")
    public FightForm getForm() {
        return new FightForm();
    }
    
}
