package org.gmnz.sb.jsf.phaselisteners;

import org.gmnz.sb.jsf.phaselisteners.model.Profession;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfessionsLoader implements SystemEventListener {

    public static final String KEY_PROFESSIONS = "K_PROFESSIONS";

    private static final String[][] TABLE_PROFESSIONS = {
            {"Teacher", "Education"}, {"Engineer", "TLC"},
            {"Doctor", "Health"}, {"Agent", "Security"}
    };

    @Override
    public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {
        Map<String, Object> applicationMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();

    }

    @Override
    public boolean isListenerForSource(Object o) {
        return o instanceof javax.faces.application.Application;
    }

    private List<SelectItem> getStandardProfessions() {
        List<SelectItem> items = new ArrayList<>();

        for (String[] arr : TABLE_PROFESSIONS) {
            Profession p = new Profession(arr[0], arr[1]);
            items.add(new SelectItem(p, String.format("%s (%s)", p.getRole(), p.getIndustry())));
        }
//        Profession p = new Profession("Teacher", "Education");
//        items.add(new SelectItem(p, String.format("%s (%s)", p.getRole(), p.getIndustry())));
//
//        p = new Profession("Engineer", "TLC");
//        items.add(new SelectItem(p, String.format("%s (%s)", p.getRole(), p.getIndustry())));
//
//        p = new Profession("Doctor", "Health");
//        items.add(new SelectItem(p, String.format("%s (%s)", p.getRole(), p.getIndustry())));
//
//        p = new Profession("Agent", "Security");
//        items.add(new SelectItem(p, String.format("%s (%s)", p.getRole(), p.getIndustry())));
        return items;
    }
}
