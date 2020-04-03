package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Shoe;



public interface ShoeRepository extends JpaRepository<Shoe, Long> {

}
