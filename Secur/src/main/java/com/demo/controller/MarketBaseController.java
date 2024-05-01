package com.demo.controller;

import com.demo.domain.MarketBase;
import com.demo.service.MarketBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MarketBaseController {
    private final MarketBaseService marketBaseService;

    public MarketBaseController(MarketBaseService marketBaseService) {
        this.marketBaseService = marketBaseService;
    }
    @PostMapping("/market_base")
    public ResponseEntity<?> crate(@RequestBody MarketBase marketBase){
        MarketBase newMarketBase=marketBaseService.save(marketBase);
        return ResponseEntity.ok(newMarketBase);
    }
    @PostMapping("/marketBase")
    public ResponseEntity<?> update(@RequestBody MarketBase marketBase){
        MarketBase newMarketBase=marketBaseService.save(marketBase);
        return ResponseEntity.ok(newMarketBase);
    }
    @GetMapping("/market_base")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        MarketBase marketBase=marketBaseService.findOne(id);
        return ResponseEntity.ok(marketBase);
    }
    @GetMapping("/marketBase")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<MarketBase> page=marketBaseService.findAll(pageable);
        return ResponseEntity.ok(page);
    }
    @DeleteMapping("/market_base")
    public void delete(@PathVariable Long id){
        marketBaseService.deleteById(id);
    }
}
