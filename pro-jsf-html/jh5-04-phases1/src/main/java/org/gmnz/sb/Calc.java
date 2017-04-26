package org.gmnz.sb;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


@ManagedBean
@RequestScoped
public class Calc implements Serializable {


    private static final long serialVersionUID = 4172363716000031686L;


    private Integer num1;
    private Integer num2;

    private Integer product;

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public void multiplicate() {
        product = num1 * num2;
    }

    public void reset() {
        num1 = null;
        num2 = null;
        product = null;
    }

    @PostConstruct
    public void postConstruct() {
        product = null;
        System.out.println("postConstruct() method invoked");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy()");
    }

}
