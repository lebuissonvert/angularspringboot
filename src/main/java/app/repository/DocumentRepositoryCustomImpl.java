package app.repository;

import app.DTO.DocumentFullDTO;
import app.entity.Document;
import app.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Repository
@Transactional
public class DocumentRepositoryCustomImpl implements DocumentRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public byte[] getBlobById(Integer idDocument) {
        byte[] resultat = null;
        Document document = entityManager.find(Document.class, idDocument);
        if(document!=null) {
            resultat = document.getDocument();
        }
        return resultat;
    }
}
