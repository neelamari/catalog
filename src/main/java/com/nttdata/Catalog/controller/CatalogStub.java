package com.nttdata.Catalog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nttdata.Catalog.model.Catalog;

public class CatalogStub {

	private static Map<Long, Catalog> catalogs = new HashMap<Long, Catalog>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		Catalog a = new Catalog(1L, "Apple iPad", "Apple iPad with white color", 399.99);
		catalogs.put(1L, a);
		Catalog b = new Catalog(2L, "Apple iPhone", "Apple iPad - black color", 899.99);
		catalogs.put(2L, b);
		Catalog c = new Catalog(3L, "Dell Inspiron Notepad", "Dell Inspiron Notepad with i5 Processor and 8G Memory", 399.99);
		catalogs.put(3L, c);		
	}

	public static List<Catalog> list() {
		return new ArrayList<Catalog>(catalogs.values());
	}

	public static Catalog create(Catalog catalog) {
		idIndex += idIndex;
		catalog.setId(idIndex);
		catalogs.put(idIndex, catalog);
		return catalog;
	}

	public static Catalog get(Long id) {
		return catalogs.get(id);
	}

	public static Catalog update(Long id, Catalog catalog) {
		catalogs.put(id, catalog);
		return catalog;
	}

	public static Catalog delete(Long id) {
		return catalogs.remove(id);
	}
}

