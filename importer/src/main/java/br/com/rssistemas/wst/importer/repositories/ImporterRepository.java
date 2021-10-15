package br.com.rssistemas.wst.importer.repositories;

import br.com.rssistemas.wst.importer.entities.Importer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImporterRepository extends JpaRepository<Importer, UUID> {
}
