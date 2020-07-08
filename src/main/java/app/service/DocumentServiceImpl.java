package app.service;

import app.DTO.DocumentFullDTO;
import app.DTO.DocumentLightDTO;
import app.entity.Document;
import app.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<DocumentLightDTO> findAllLight() {
        List<DocumentLightDTO> result = new ArrayList<>();
        Iterable<Document> documents = documentRepository.findAll();
        for(Document curDocument : documents) {
            result.add(new DocumentLightDTO(curDocument));
        }
        return result;
    }

    @Override
    public DocumentLightDTO findLightById(Integer p_id) {
        DocumentLightDTO result = null;
        Optional<Document> document = documentRepository.findById(p_id);
        if(document.isPresent()) {
            result = new DocumentLightDTO(document.get());
        }
        return result;
    }

    @Override
    public DocumentLightDTO createDocumentFull(DocumentFullDTO p_documentDTO) {
        DocumentLightDTO resultat = null;
        if(p_documentDTO != null) {
            Document updatedDocument = documentRepository.save(p_documentDTO.toDocument());
            if(updatedDocument!=null) {
                resultat = new DocumentLightDTO(updatedDocument);
            }
        }
        return resultat;
    }

    @Override
    public DocumentLightDTO saveDocumentFull(DocumentFullDTO p_documentDTO) {
        DocumentLightDTO resultat = null;
        Optional<Document> document = documentRepository.findById(p_documentDTO.getIdDocument());
        if(document.isPresent()) {
            document.get().setIdDocument(p_documentDTO.getIdDocument());
            document.get().setCodeDocument(p_documentDTO.getCodeDocument());
            document.get().setDocument(p_documentDTO.getDocument());

            Document updatedDocument = documentRepository.save(document.get());
            if(updatedDocument!=null) {
                resultat = new DocumentLightDTO(updatedDocument);
            }
        }
        return resultat;
    }

    @Override
    public byte[] getDocumentBlobById(Integer p_id) {
        byte[] result = null;
        Optional<Document> document = documentRepository.findById(p_id);
        if(document.isPresent()) {
            result = document.get().getDocument();
        }
        return result;
    }
}
