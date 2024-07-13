package com.valentinejavastocks.Controllers;

import com.valentinejavastocks.Converters.StockOperationConverter;
import com.valentinejavastocks.DTOs.StockOperationDTO;
import com.valentinejavastocks.Domains.StockOperation;
import com.valentinejavastocks.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public List<StockOperation> getStockOperations () {
        return this.stockService.getAllStockOperations();
    }

    @GetMapping("/operation")
    public List<StockOperationDTO> getStockOperations (@RequestBody Long userId) {
        return stockService.getStockOperations(userId).stream().map(StockOperationConverter::toDTO).toList();
    }

    @PutMapping("/operation")
    public StockOperation addStockOperation (@RequestBody StockOperationDTO stockOperation) {
        return stockService.addStockOperation(StockOperationConverter.toEntity(stockOperation));
    }

}
