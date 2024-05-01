package com.demo.service;

import com.demo.domain.MarketBase;
import com.demo.repository.MarketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketBaseService {
    private final MarketRepository marketRepository;

    public MarketBaseService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }
    public MarketBase save(MarketBase marketBase){
        return marketRepository.save(marketBase);
    }
    public MarketBase findOne(Long id){
        Optional<MarketBase> base=marketRepository.findById(id);
        if (base.isPresent()){
            MarketBase marketBase=base.get();
            return marketBase;
        }
        return null;
    }
    public Page<MarketBase> findAll(Pageable pageable){
        Page<MarketBase> page=marketRepository.findAll(pageable);
        return page;
    }
    public void deleteById(Long id){
        marketRepository.deleteById(id);
    }
}
