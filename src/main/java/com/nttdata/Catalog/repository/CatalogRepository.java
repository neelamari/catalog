package com.nttdata.Catalog.repository;

import com.nttdata.Catalog.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long>{

}