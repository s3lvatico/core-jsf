package org.gmnz.sb.jsf.phaselisteners.converter;

import org.gmnz.sb.jsf.phaselisteners.model.Address;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

// viene dichiarato anche nel faces-config.xml
public class AddressConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        String[] tokens = s.split("\\|");
        if (tokens.length != 4
                || tokens[0].length() < 2
                || tokens[2].length() != 5
                || tokens[3].length() < 2) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong address format", "the address format should be in the form <street> | <town>(optional) | postal code (5 numbers) | city");
            throw new ConverterException(msg);
        }

        Address a = new Address();
        a.setStreet(tokens[0]);
        a.setTown(tokens[1].length() == 0 ? "" : tokens[1]);
        a.setPostalCode(tokens[2]);
        a.setCity(tokens[3]);

        return a;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Address a = (Address) o;
        return String.format("%s|%s|%s|%s", a.getStreet(), a.getTown(), a.getPostalCode(), a.getCity());
    }

    public static void main(String[] args) {
        String a1 = "via Parco 2/B|San Mariano|06073|Corciano (PG)";

        String[] t1 = a1.split("\\|");
        System.out.printf("prima stringa composta da %d elementi%n", t1.length);
        for (String s : t1) System.out.printf("[%d] <%s>%n", s.length(), s);
        String a2 = "viale Roma, 47||06073|Perugia";
        String[] t2 = a2.split("\\|");
        System.out.printf("seconda stringa composta da %d elementi%n", t2.length);
        for (String s : t2) {
            System.out.printf("[%d] <%s>%n", s.length(), s);
        }

        /*
        ne consegue: nella logica, se ho due separatori adiacenti viene comunque riconosciuta una stringa al loro interno, solo che è o vuota
         */
        // risulta in ogni caso che l'array di stringhe è di lunghezza COSTANTE
        // questo è già un elemento importante ai fini della validazione
        System.out.format("ora un null: <%s>%n", null);
        // la riga sopra dimostra che se provo a formattare in stringa il valore null viene effettivamente scritto "null"
    }
}