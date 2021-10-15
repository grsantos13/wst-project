package br.com.rssistemas.wst.operation.repositories;

import br.com.rssistemas.wst.operation.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRepository extends JpaRepository<Operation, UUID> {
}
