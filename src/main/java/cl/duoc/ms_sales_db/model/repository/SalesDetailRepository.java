package cl.duoc.ms_sales_db.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.ms_sales_db.model.entities.SalesDetail;

@Repository
public interface SalesDetailRepository extends JpaRepository<SalesDetail, Long>{

}
