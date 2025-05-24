package cl.duoc.ms_sales_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_sales_db.model.dto.SalesDTO;
import cl.duoc.ms_sales_db.service.SalesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    SalesService salesService;

    @GetMapping("/{id}")
    public SalesDTO findSalesById(@PathVariable Long id) {
        return salesService.findSalesById(id);
    }
    

}
