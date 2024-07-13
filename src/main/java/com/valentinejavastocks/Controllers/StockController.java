package com.valentinejavastocks.Controllers;

import com.valentinejavastocks.Converters.StockOperationConverter;
import com.valentinejavastocks.DTOs.StockOperationDTO;
import com.valentinejavastocks.Domains.StockOperation;
import com.valentinejavastocks.Services.StockService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final StockOperationConverter stockOperationConverter;

    @GetMapping("/health")
    public ResponseEntity<String> health () {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping
    public List<StockOperationDTO> getStockOperations () {
        return stockService.getAllStockOperations().stream().map(stockOperationConverter::toDTO).toList();
    }

    @GetMapping("/operation")
    public List<StockOperationDTO> getStockOperations (@RequestParam Long userId) {
        return stockService.getStockOperations(userId).stream().map(stockOperationConverter::toDTO).toList();
    }

    @PostMapping("/operation")
    public StockOperationDTO addStockOperation (@RequestBody StockOperationDTO stockOperation) {
        return stockOperationConverter.toDTO(stockService.addStockOperation(stockOperationConverter.toEntity(stockOperation)));
    }

}
