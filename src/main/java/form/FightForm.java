package form;

import java.util.List;

import entity.PictureInfo;

public class FightForm {
    private String gameMode;
    private String answer;
    private String question;
    private List<PictureInfo> picInfoList;
    private List<String> alreadyUseQuestionList;
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public List<PictureInfo> getPicInfoList() {
        return picInfoList;
    }
    
    public void setPicInfoList(List<PictureInfo> picInfoList) {
        this.picInfoList = picInfoList;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public List<String> getAlreadyUseQuestionList() {
        return alreadyUseQuestionList;
    }
    
    public void setAlreadyUseQuestionList(List<String> alreadyUseQuestionList) {
        this.alreadyUseQuestionList = alreadyUseQuestionList;
    }
    
    public String getGameMode() {
        return gameMode;
    }
    
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
    
}
