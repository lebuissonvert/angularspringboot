package app.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DocumentRepositoryCustom {
    public byte[] getBlobById(Integer idDocument);
}
