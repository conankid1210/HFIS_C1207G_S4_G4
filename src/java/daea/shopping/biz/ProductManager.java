/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daea.shopping.biz;

import daea.shopping.da.ProductsJpaController;
import daea.shopping.entity.Products;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author Nghia
 */

@Stateless
@TransactionManagement (TransactionManagementType.BEAN)
public class ProductManager {

    @PersistenceUnit(unitName = "ShopDemoPU")
    private EntityManagerFactory emf;
    
   @Resource
   private UserTransaction utx;
   
   private ProductsJpaController daController;
   
   public ProductsJpaController getDAController()
   {
       if (daController==null)
       {
           daController= new ProductsJpaController(utx, emf);
       }
       return daController;
   }
   
   public List<Products> findProductByName(String keyword)
   {
       return getDAController().findProductsByName(keyword);
   }
    
}
