package common;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import form.FightForm;

@SuppressWarnings("serial")
public class SessionAccessor implements Serializable {
    private HttpServletRequest request;
    private static final String FIGHT_FORM = "form.FightForm";

    public SessionAccessor(HttpServletRequest request) {
        this.request = request;
    }

    public String getId() {
        HttpSession session = this.request.getSession();
        return session.getId();
    }

    public FightForm getFightForm() {
        HttpSession session = this.request.getSession();
        return (FightForm) session.getAttribute(FIGHT_FORM);
    }

    public void setFightForm(FightForm fightForm) {
        HttpSession session = this.request.getSession();
        session.setAttribute(FIGHT_FORM, fightForm);
    }

}
