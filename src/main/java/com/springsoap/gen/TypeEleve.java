//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.06.22 à 05:33:07 PM CEST 
//


package com.springsoap.gen;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour typeEleve.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="typeEleve">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Guideur"/>
 *     &lt;enumeration value="Guidé"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeEleve")
@XmlEnum
public enum TypeEleve {

    @XmlEnumValue("Guideur")
    GUIDEUR("Guideur"),
    @XmlEnumValue("Guid\u00e9")
    GUIDÉ("Guid\u00e9");
    private final String value;

    TypeEleve(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeEleve fromValue(String v) {
        for (TypeEleve c: TypeEleve.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
