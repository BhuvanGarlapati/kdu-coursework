package com.example.assesment2.service;

import com.example.assesment2.dto.CatalogDto;
import com.example.assesment2.entity.Catalog;
import com.example.assesment2.exception.ErrorWhileExecutingQuery;
import com.example.assesment2.mapper.Mapper;
import com.example.assesment2.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class CatalogService {

    private CatalogRepository catalogRepository;

    @Autowired
    public CatalogService(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    public CatalogDto addProduct(Catalog catalog){
        try {
            Catalog catalog1 = catalogRepository.save(catalog);
            return Mapper.convertToProduct(catalog1);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding products");
        }
    }


    public boolean deleteCatalog(Integer Id) {
        Optional<Catalog> optionalCatalog = catalogRepository.findById(Id);

        if (optionalCatalog.isPresent()) {
            catalogRepository.deleteById(Id);
            return true;
        } else {
            return false;
        }
    }
    public Catalog updateCatalog(Integer Id, String name) {
        Catalog event = catalogRepository.findById(Id).orElse(null);
        if (event != null) {
            event.setName(name);
            catalogRepository.save(event);
        }
        return event;
    }
}
