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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour cours complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="cours">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="niveau" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prof" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nbCavaliers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbCavalieres" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="eleves" type="{com/springsoap/gen}listeEleves"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cours", propOrder = {
    "id",
    "title",
    "start",
    "end",
    "adresse",
    "niveau",
    "prof",
    "ville",
    "nbCavaliers",
    "nbCavalieres",
    "eleves"
})
public class Cours {

    protected int id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlElement(required = true)
    protected String adresse;
    @XmlElement(required = true)
    protected String niveau;
    @XmlElement(required = true)
    protected String prof;
    @XmlElement(required = true)
    protected String ville;
    protected int nbCavaliers;
    protected int nbCavalieres;
    @XmlElement(required = true)
    protected ListeEleves eleves;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Obtient la valeur de la propriété start.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Définit la valeur de la propriété start.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Obtient la valeur de la propriété end.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Définit la valeur de la propriété end.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propriété niveau.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNiveau() {
        return niveau;
    }

    /**
     * Définit la valeur de la propriété niveau.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNiveau(String value) {
        this.niveau = value;
    }

    /**
     * Obtient la valeur de la propriété prof.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProf() {
        return prof;
    }

    /**
     * Définit la valeur de la propriété prof.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProf(String value) {
        this.prof = value;
    }

    /**
     * Obtient la valeur de la propriété ville.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la valeur de la propriété ville.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * Obtient la valeur de la propriété nbCavaliers.
     * 
     */
    public int getNbCavaliers() {
        return nbCavaliers;
    }

    /**
     * Définit la valeur de la propriété nbCavaliers.
     * 
     */
    public void setNbCavaliers(int value) {
        this.nbCavaliers = value;
    }

    /**
     * Obtient la valeur de la propriété nbCavalieres.
     * 
     */
    public int getNbCavalieres() {
        return nbCavalieres;
    }

    /**
     * Définit la valeur de la propriété nbCavalieres.
     * 
     */
    public void setNbCavalieres(int value) {
        this.nbCavalieres = value;
    }

    /**
     * Obtient la valeur de la propriété eleves.
     * 
     * @return
     *     possible object is
     *     {@link ListeEleves }
     *     
     */
    public ListeEleves getEleves() {
        return eleves;
    }

    /**
     * Définit la valeur de la propriété eleves.
     * 
     * @param value
     *     allowed object is
     *     {@link ListeEleves }
     *     
     */
    public void setEleves(ListeEleves value) {
        this.eleves = value;
    }

}
