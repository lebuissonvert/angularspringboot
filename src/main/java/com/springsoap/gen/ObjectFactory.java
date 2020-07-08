//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.06.22 à 05:33:07 PM CEST 
//


package com.springsoap.gen;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.springsoap.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.springsoap.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCoursByMonthAndYearSoapResponse }
     * 
     */
    public GetCoursByMonthAndYearSoapResponse createGetCoursByMonthAndYearSoapResponse() {
        return new GetCoursByMonthAndYearSoapResponse();
    }

    /**
     * Create an instance of {@link ListeCours }
     * 
     */
    public ListeCours createListeCours() {
        return new ListeCours();
    }

    /**
     * Create an instance of {@link GetCoursByMonthAndYearSoapRequest }
     * 
     */
    public GetCoursByMonthAndYearSoapRequest createGetCoursByMonthAndYearSoapRequest() {
        return new GetCoursByMonthAndYearSoapRequest();
    }

    /**
     * Create an instance of {@link ListeEleves }
     * 
     */
    public ListeEleves createListeEleves() {
        return new ListeEleves();
    }

    /**
     * Create an instance of {@link Eleve }
     * 
     */
    public Eleve createEleve() {
        return new Eleve();
    }

    /**
     * Create an instance of {@link Cours }
     * 
     */
    public Cours createCours() {
        return new Cours();
    }

}
