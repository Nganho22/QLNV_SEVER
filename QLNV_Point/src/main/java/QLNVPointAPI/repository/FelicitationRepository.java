package QLNVPointAPI.repository;

import QLNVPointAPI.model.Felicitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelicitationRepository extends JpaRepository<Felicitation, Integer> {
}
