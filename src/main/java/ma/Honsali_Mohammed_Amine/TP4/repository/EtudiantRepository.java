package ma.Honsali_Mohammed_Amine.TP4.repository;

import ma.Honsali_Mohammed_Amine.TP4.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
