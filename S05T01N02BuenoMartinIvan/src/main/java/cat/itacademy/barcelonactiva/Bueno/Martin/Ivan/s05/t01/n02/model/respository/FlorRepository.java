package cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.respository;

import cat.itacademy.barcelonactiva.Bueno.Martin.Ivan.s05.t01.n02.model.domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {

}
