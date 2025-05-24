package cl.duoc.ms_sales_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_sales_db.model.repository.SalesDetailRepository;
import cl.duoc.ms_sales_db.model.repository.SalesRepository;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    SalesDetailRepository salesDetailRepository;

    public SalesDTO findSalesById(Long id){
        
    }
}
