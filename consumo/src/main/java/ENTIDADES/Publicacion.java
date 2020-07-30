/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDADES;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SICOJUMP
 */
@Entity
@Table(name = "publicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacion.findAll", query = "SELECT p FROM Publicacion p")
    , @NamedQuery(name = "Publicacion.findByIdpublicacion", query = "SELECT p FROM Publicacion p WHERE p.idpublicacion = :idpublicacion")
    , @NamedQuery(name = "Publicacion.findByAutores", query = "SELECT p FROM Publicacion p WHERE p.autores = :autores")
    , @NamedQuery(name = "Publicacion.findByUrl", query = "SELECT p FROM Publicacion p WHERE p.url = :url")
    , @NamedQuery(name = "Publicacion.findByDescripcion", query = "SELECT p FROM Publicacion p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Publicacion.findByCorreoelectronico", query = "SELECT p FROM Publicacion p WHERE p.correoelectronico = :correoelectronico")
    , @NamedQuery(name = "Publicacion.findByCoautores", query = "SELECT p FROM Publicacion p WHERE p.coautores = :coautores")})
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpublicacion")
    private Integer idpublicacion;
    @Basic(optional = false)
    @Column(name = "autores")
    private String autores;
    @Column(name = "url")
    private String url;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "correoelectronico")
    private String correoelectronico;
    @Column(name = "coautores")
    private String coautores;
    @JoinColumn(name = "idtipo", referencedColumnName = "idtipo")
    @ManyToOne(optional = false)
    private Tipo idtipo;

    public Publicacion() {
    }

    public Publicacion(Integer idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public Publicacion(Integer idpublicacion, String autores) {
        this.idpublicacion = idpublicacion;
        this.autores = autores;
    }

    public Integer getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(Integer idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getCoautores() {
        return coautores;
    }

    public void setCoautores(String coautores) {
        this.coautores = coautores;
    }

    public Tipo getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tipo idtipo) {
        this.idtipo = idtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpublicacion != null ? idpublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.idpublicacion == null && other.idpublicacion != null) || (this.idpublicacion != null && !this.idpublicacion.equals(other.idpublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTIDADES.Publicacion[ idpublicacion=" + idpublicacion + " ]";
    }
    
}
