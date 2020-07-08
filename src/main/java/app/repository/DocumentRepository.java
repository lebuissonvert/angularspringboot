package app.repository;

import app.entity.Document;
import app.entity.Icone;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Integer>, DocumentRepositoryCustom {

    Document findByCodedocument(String codeDocument);

}
