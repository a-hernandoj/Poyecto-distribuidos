package es.urjc.etsii.dad.helloworld;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartasRepository extends JpaRepository<Cartas,Long>{
		List<Cartas> findBynombre(String nombre);
}
