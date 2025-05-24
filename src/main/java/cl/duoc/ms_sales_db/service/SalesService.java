package cl.duoc.ms_sales_db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_sales_db.model.dto.SalesDTO;
import cl.duoc.ms_sales_db.model.dto.SalesDetailDTO;
import cl.duoc.ms_sales_db.model.entities.Sales;
import cl.duoc.ms_sales_db.model.entities.SalesDetail;
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

            List<SalesDetail> salesDetailList = salesDetailRepository.findBySalesId(sales.get().getId());
            salesDto.setSalesDetailDtoList(translateListEntityToDto(salesDetailList));
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

    public List<SalesDetailDTO> translateListEntityToDto(List<SalesDetail> saleDetail){
        List<SalesDetailDTO> lista = new ArrayList<>();
        SalesDetailDTO salesDetailDTO = null;
        for(SalesDetail detail: saleDetail){
            salesDetailDTO = new SalesDetailDTO();
            salesDetailDTO.setId(detail.getId());
            salesDetailDTO.setProductId(detail.getProductId());
            salesDetailDTO.setQuantity(detail.getQuantity());
            salesDetailDTO.setSalesId(detail.getSalesId());
            lista.add(salesDetailDTO);
        }
        return lista;
    }

}
