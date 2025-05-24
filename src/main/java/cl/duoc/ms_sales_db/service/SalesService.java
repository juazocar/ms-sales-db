package cl.duoc.ms_sales_db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_sales_db.model.dto.SalesDTO;
import cl.duoc.ms_sales_db.model.entities.Sales;
import cl.duoc.ms_sales_db.model.repository.SalesDetailRepository;
import cl.duoc.ms_sales_db.model.repository.SalesRepository;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    SalesDetailRepository salesDetailRepository;

    public SalesDTO findSalesById(Long id){
        Optional<Sales> sales = salesRepository.findById(id);       
        //Validamos si existe o no
        SalesDTO salesDto = null;

        if(sales.isPresent()){
            salesDto = translateEntityToDto(sales.get());
        } else {
            salesDto = new SalesDTO();
        }
        return salesDto;

    }

      public SalesDTO translateEntityToDto(Sales sale){
        SalesDTO salesDto = new SalesDTO();
        salesDto.setId(sale.getId());
        salesDto.setAmount(sale.getAmount());
        //salesDto.setSalesDate(sale.getSalesDate());
        salesDto.setCustomerId(sale.getCustomerId());
        return salesDto;
    }

}
