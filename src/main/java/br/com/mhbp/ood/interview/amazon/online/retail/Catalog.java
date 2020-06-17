package br.com.mhbp.ood.interview.amazon.online.retail;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//Users of our system can search for products by their name or productCategory. This class will keep an index of all products for faster search.
public class Catalog {

    ConcurrentHashMap<String, Set<Product>> productNames;
    ConcurrentHashMap<String, Set<Product>> productCategories;

    void add(Product p) {}

    public Set<Product> searchProductsByName(String name) {
        return productNames.get(name);
    }

    public Set<Product> searchProductsByCategory(String category) {
        return productCategories.get(category);
    }
}

//PageRequest Pageable!!!! look in spring data jpa