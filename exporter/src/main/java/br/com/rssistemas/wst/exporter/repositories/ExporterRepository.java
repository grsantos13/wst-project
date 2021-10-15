package br.com.rssistemas.wst.exporter.repositories;

import br.com.rssistemas.wst.exporter.entities.Exporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExporterRepository extends JpaRepository<Exporter, UUID> {
}
