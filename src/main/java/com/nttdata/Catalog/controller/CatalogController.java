package com.nttdata.Catalog.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.Catalog.model.Catalog;
import com.nttdata.Catalog.repository.CatalogRepository;

@RestController
@RequestMapping("api/v1/")
public class CatalogController {

	@Autowired
	private CatalogRepository CatalogRepository;
	
	@RequestMapping(value = "Catalogs", method = RequestMethod.GET)
	public List<Catalog> list() {
		return CatalogRepository.findAll();
	}
	
	@RequestMapping(value = "Catalogs", method = RequestMethod.POST)
	public Catalog create(@RequestBody Catalog Catalog) {
		return CatalogRepository.saveAndFlush(Catalog);
	}
	
	@RequestMapping(value = "Catalogs/{id}", method = RequestMethod.GET)
	public Catalog get(@PathVariable Long id ) {
		return CatalogRepository.findOne(id);
	}
		
	@RequestMapping(value = "Catalogs/{id}", method = RequestMethod.PUT)
	public Catalog update(@PathVariable Long id, @RequestBody Catalog Catalog ) {
		Catalog existingCatalog = CatalogRepository.findOne(id);
		BeanUtils.copyProperties(Catalog, existingCatalog);
		return CatalogRepository.saveAndFlush(existingCatalog);
	}
	
	@RequestMapping(value = "Catalogs/{id}", method = RequestMethod.DELETE)
	public Catalog delete(@PathVariable Long id ) {
		Catalog existingCatalog = CatalogRepository.findOne(id);
		CatalogRepository.delete(existingCatalog);
		return existingCatalog;
	}
	
}
