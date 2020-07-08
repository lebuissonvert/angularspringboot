package app.service;

import app.DTO.DocumentFullDTO;
import app.DTO.DocumentLightDTO;

import java.util.List;

public interface IDocumentService {

    public List<DocumentLightDTO> findAllLight();
    public DocumentLightDTO findLightById(Integer id);

    public DocumentLightDTO saveDocumentFull(DocumentFullDTO document);
    public DocumentLightDTO createDocumentFull(DocumentFullDTO document);
    public byte[] getDocumentBlobById(Integer id);
}
