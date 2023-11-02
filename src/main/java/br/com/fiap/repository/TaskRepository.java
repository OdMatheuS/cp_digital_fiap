package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
