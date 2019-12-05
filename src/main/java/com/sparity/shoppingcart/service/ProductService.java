package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.Product;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;

public interface ProductService extends BaseService {
	
		public void save(Product product);
		public List<ProductModel> findAllProducts(int page,int rows); 
		int countTransactions();
		public List<ProductModel> findSpecificBrandProds(Long brandId);
		public List<Object> brandPriceRange(Long brandId);
		//public List<ProductModel> getAllMobiles(Long categoryId);
		public List<ProductModel> priceRangeProducts(Double minPrice,Double maxPrice,Long brandId);
		public List<ProductTypeModel> getProductTypes();
		public List<BrandModel> getBrands();
		public List<BrandModel> getMobileBrands(Long categoryId);
		public List<ProductModel> getProductTypes(Long prodTypeId,int page, int rows);
		public List<ProductModel> getProductTypes(Long prodTypeId,Long brandId);
		//public List<ProductTypeModel> getProductTypes(prodTypeId);
		public List<ProductModel> selectMultilpleBrandProdIds(List<Long> prodTypeIdList,List<Long> brandIdList,Double minPrice,Double maxPrice);
		
		public List<ProductTypeModel> getCategoryTypes(Long categoryId);
		//public List<ProductModel> findSpecificBrandProds(brandId,categoryId);
		public String compareProds(String item1,String item2);

		public List<ProductModel> findAllProductsHomePage();
		
		public List<ProductModel> findDataOfCheckBox(List<Long> gridCompare);
		
		public int getCountForCategoryProducts(Long categoryId);
		public List<ProductModel> getAllCategoryProds(Long categoryId,int page,int rows);
		
		public int getCountForBrandCategoryProducts(Long categoryId, Long brandId);
		public List<ProductModel> getBrandCategoryProds(Long categoryId, Long brandId,int page,int rows);
		
		public int getCountForProdTypes(Long prodTypeId);
		public int productTypeBrandsCount(List<Long> prodTypeId,List<Long> brandId,Long categoryId, Double minPrice,Double maxPrice);
		public List<ProductModel> getProdsFromProdTypeAndBrands(List<Long> prodTypeId,List<Long> brandId,Long categoryId,int page,int rows, Double minPrice,Double maxPrice);
		public List<Object> getMinAndMaxPriceForProducts(Long categoryId,Long brandId,Long prodTypeId); 
		
		public int getProductPriceRangeCount(Double minPrice,Double maxPrice,Long categoryId);
		public List<ProductModel> getPriceRangeProducts(Long categoryId,Double minPrice, Double maxPrice,int page,int rows);
		
		public List<ProductModel> getAllCategoryProds(Long categoryId);
		public List<ProductModel> getAllBrandProds(Long categoryId,Long brandId);
		
		//Methods for only producttype filter selections...
		public int productTypesCount(List<Long> prodTypeId, Long brandId,Long categoryId,Double minPrice,Double maxPrice);
		public List<ProductModel> getProdsFromProdType(List<Long> prodTypeId, Long brandId,Long categoryId,int page,int rows, Double minPrice,Double maxPrice);
		
		//Methods for only Brand filter selections...
		public int brandsCount(Long prodTypeId, List<Long> brandId, Long categoryId,Double minPrice,Double maxPrice);
		public List<ProductModel> getProdsFromBrands(Long prodTypeId, List<Long> brandId,Long categoryId,int page,int rows, Double minPrice,Double maxPrice);
		
		public void updatepricedetails(ProductModel pmo);
		public ProductModel getproductIdRow(Long productid);
		public void updateStatus(ProductModel pmo);
		
}
