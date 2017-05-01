package org.gmnz.sb.jsf.phaselisteners.listener;

import org.gmnz.sb.jsf.phaselisteners.model.Profession;

import javax.faces.context.FacesContext;
import javax.faces.event.*;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfessionsLoader implements SystemEventListener {

    public static final String KEY_PROFESSIONS = "professions";

    private static final String[][] TABLE_PROFESSIONS = {
            {"Teacher", "Education"}, {"Engineer", "TLC"},
            {"Doctor", "Health"}, {"Agent", "Security"}
    };

    @Override
    public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {
        Map<String, Object> applicationMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();

        if (systemEvent instanceof PostConstructApplicationEvent) {
            System.out.println("APPLICATION postConstruct");
            applicationMap.put(KEY_PROFESSIONS, getStandardProfessions());
        } else if (systemEvent instanceof PreDestroyApplicationEvent) {
            System.out.println("APPLICATION preDestroy");
            applicationMap.remove(KEY_PROFESSIONS);
        }
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
        return items;
    }
}
