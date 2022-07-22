package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public List<Category> findByStatusTrue();
    public List<Category> findByDomainAndStatusTrue(Domain d);
    public Category findByDomainAndNomAndStatusTrue(Domain d, String nom);


}
