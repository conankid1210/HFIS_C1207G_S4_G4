/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daea.shopping.ui;

import daea.shopping.biz.ProductManager;
import daea.shopping.entity.Products;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nghia
 */
@ManagedBean
@SessionScoped
public class Home {
    @EJB
    private ProductManager productManager;

    private String keyword;
    private List<Products> products;

    public Home() {
    }

    
    public void search()
    {
        products = productManager.findProductByName(keyword);
    }
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Products> getProducts() {
        return products;
    }

}
