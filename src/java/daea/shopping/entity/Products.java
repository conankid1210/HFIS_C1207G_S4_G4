/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daea.shopping.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nghia
 */
@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProID", query = "SELECT p FROM Products p WHERE p.proID = :proID"),
    @NamedQuery(name = "Products.findByProName", query = "SELECT p FROM Products p WHERE p.proName = :proName"),
    @NamedQuery(name = "Products.findByProPrice", query = "SELECT p FROM Products p WHERE p.proPrice = :proPrice"),
    @NamedQuery(name = "Products.findByProDes", query = "SELECT p FROM Products p WHERE p.proDes = :proDes")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProID")
    private Integer proID;
    @Size(max = 50)
    @Column(name = "ProName")
    private String proName;
    @Column(name = "ProPrice")
    private Integer proPrice;
    @Size(max = 1073741823)
    @Column(name = "ProDes")
    private String proDes;

    public Products() {
    }

    public Products(Integer proID) {
        this.proID = proID;
    }

    public Integer getProID() {
        return proID;
    }

    public void setProID(Integer proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getProPrice() {
        return proPrice;
    }

    public void setProPrice(Integer proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proID != null ? proID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.proID == null && other.proID != null) || (this.proID != null && !this.proID.equals(other.proID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "daea.shopping.entity.Products[ proID=" + proID + " ]";
    }
    
}
