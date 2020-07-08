//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.06.22 à 05:33:07 PM CEST 
//


package com.springsoap.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeCours" type="{com/springsoap/gen}listeCours"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listeCours"
})
@XmlRootElement(name = "getCoursByMonthAndYearSoapResponse")
public class GetCoursByMonthAndYearSoapResponse {

    @XmlElement(required = true)
    protected ListeCours listeCours;

    /**
     * Obtient la valeur de la propriété listeCours.
     * 
     * @return
     *     possible object is
     *     {@link ListeCours }
     *     
     */
    public ListeCours getListeCours() {
        return listeCours;
    }

    /**
     * Définit la valeur de la propriété listeCours.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeCours }
     *     
     */
    public void setListeCours(ListeCours value) {
        this.listeCours = value;
    }

}
