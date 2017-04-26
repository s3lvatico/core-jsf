package org.gmnz.sb;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;


public class CbtnMultiplyActionListener implements ActionListener {

    @Override
    public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
        System.out.println("nice - you are inside le actionListener!");
        FacesContext ctx = FacesContext.getCurrentInstance();
        Calc calc = ctx.getApplication().evaluateExpressionGet(ctx, "#{calc}", Calc.class);
        calc.setProduct(calc.getNum1() * calc.getNum2());
    }
}
