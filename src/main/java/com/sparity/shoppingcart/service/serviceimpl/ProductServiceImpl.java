package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.ProductDAO;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.Product;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl implements
		ProductService {
	private final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Resource(name = "productDAO")
	private ProductDAO productDao;

	public ProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	public void save(Product product) {
		
		if(logger.isDebugEnabled())
		logger.info("inside save of ProductServiceeImpl");
		saveObject(product);
	}
	
	public String compareProds(String item1,String item2){
		
		return "str";
	}

	@Override
	public List<ProductModel> findAllProducts(int page,int rows){
		return productDao.findAllProducts(page,rows);
	}

	@Override
	public int countTransactions() {
		return productDao.countTransactions();
	}

	@Override
	public List<ProductModel> findSpecificBrandProds(Long brandId) {
		return productDao.findSpecificBrandProds(brandId);
	}

	@Override
	public List<Object> brandPriceRange(Long brandId) {
		return productDao.brandPriceRange(brandId);
	}

//	@Override
//	public List<ProductModel> priceRangeProducts(Double minPrice,
//			Double maxPrice) {
//		// TODO Auto-generated method stub
//		return productDao.priceRangeProducts(minPrice, maxPrice);
//	}

	@Override
	public List<ProductModel> getAllCategoryProds(Long categoryId) {
		return productDao.getAllCategoryProds(categoryId);
	}

	@Override
	public List<ProductModel> priceRangeProducts(Double minPrice,
			Double maxPrice, Long brandId) {
		return productDao.priceRangeProducts(minPrice, maxPrice, brandId);
	}
	 public List<ProductTypeModel> getProductTypes(){
		 return productDao.getProductTypes();
	     }

		public List<BrandModel> getBrands(){
			return productDao.getBrands();
		}
		@Override
		public List<BrandModel> getMobileBrands(Long categoryId) {
			return productDao.getMobileBrands(categoryId);
			
		}
		@Override
		public List<ProductModel> getProductTypes(Long prodTypeId,int page, int rows) {
			return productDao.getProductTypes(prodTypeId,page,rows);
		}

		@Override
		public List<ProductModel> getProductTypes(Long prodTypeId, Long brandId) {
			return productDao.getProductTypes(prodTypeId,brandId);
		}

		public List<ProductTypeModel> getCategoryTypes(Long categoryId){
			return productDao.getCategoryTypes(categoryId);
		}
		
		
	@Override
		public List<ProductModel> selectMultilpleBrandProdIds(List<Long> prodTypeIds,
				List<Long> brandIds,Double minPrice,Double maxPrice) {
		
		
			return productDao.selectMultilpleBrandProdIds(prodTypeIds,brandIds,minPrice,maxPrice);
		}

	@Override
	public List<ProductModel> findAllProductsHomePage() {
		return productDao.findAllProductsHomePage();
	}


	@Override
	public List<ProductModel> findDataOfCheckBox(List<Long> gridCompare) {
		return   productDao.findDataOfCheckBox(gridCompare);
	}

	@Override
	public int getCountForCategoryProducts(Long categoryId) {
		return productDao.getCountForCategoryProducts(categoryId);
	}

	@Override
	public List<ProductModel> getAllCategoryProds(Long categoryId, int page,
			int rows) {
		return productDao.getAllCategoryProds(categoryId, page, rows);
	}

	@Override
	public int getCountForBrandCategoryProducts(Long categoryId, Long brandId) {
		return productDao.getCountForBrandCategoryProducts(categoryId, brandId);
	}

	@Override
	public List<ProductModel> getBrandCategoryProds(Long categoryId,
			Long brandId, int page, int rows) {
		return productDao.getBrandCategoryProds(categoryId, brandId, page, rows);
	}

	@Override
	public int getCountForProdTypes(Long prodTypeId) {
		return productDao.getCountForProdTypes(prodTypeId);
	}

	@Override
	public int productTypeBrandsCount(List<Long> prodTypeId,
			List<Long> brandId, Long categoryId, Double minPrice,Double maxPrice) {
		return productDao.productTypeBrandsCount(prodTypeId, brandId, categoryId, minPrice, maxPrice);
	}

	@Override
	public List<ProductModel> getProdsFromProdTypeAndBrands(
			List<Long> prodTypeId, List<Long> brandId, Long categoryId,
			int page, int rows,Double minPrice,Double maxPrice) {
		return productDao.getProdsFromProdTypeAndBrands(prodTypeId, brandId, categoryId, page, rows, minPrice,maxPrice);
	}

	@Override
	public List<Object> getMinAndMaxPriceForProducts(Long categoryId,
			Long brandId, Long prodTypeId) {
		return productDao.getMinAndMaxPriceForProducts(categoryId, brandId, prodTypeId);
	}

	@Override
	public int getProductPriceRangeCount(Double minPrice, Double maxPrice,
			Long categoryId) {
		return productDao.getProductPriceRangeCount(minPrice, maxPrice, categoryId);
	}

	@Override
	public List<ProductModel> getPriceRangeProducts(Long categoryId,
			Double minPrice, Double maxPrice, int page, int rows) {
		return productDao.getPriceRangeProducts(categoryId, minPrice, maxPrice, page, rows);
	}

	@Override
	public int productTypesCount(List<Long> prodTypeId, Long brandId,
			Long categoryId, Double minPrice, Double maxPrice) {
		return productDao.productTypesCount(prodTypeId, brandId, categoryId, minPrice, maxPrice);
	}

	@Override
	public List<ProductModel> getProdsFromProdType(List<Long> prodTypeId,
			Long brandId, Long categoryId, int page, int rows, Double minPrice,
			Double maxPrice) {
		return productDao.getProdsFromProdType(prodTypeId, brandId, categoryId, page, rows, minPrice, maxPrice);
	}

	@Override
	public int brandsCount(Long prodTypeId, List<Long> brandId,
			Long categoryId, Double minPrice, Double maxPrice) {
		return productDao.brandsCount(prodTypeId, brandId, categoryId, minPrice, maxPrice);
	}

	@Override
	public List<ProductModel> getProdsFromBrands(Long prodTypeId,
			List<Long> brandId, Long categoryId, int page, int rows,
			Double minPrice, Double maxPrice) {
		return productDao.getProdsFromBrands(prodTypeId, brandId, categoryId, page, rows, minPrice, maxPrice);
	}

	@Override
	public List<ProductModel> getAllBrandProds(Long categoryId, Long brandId) {
		return productDao.getAllBrandProds(categoryId, brandId);
	}

	@Override
	public void updatepricedetails(ProductModel pmo) {
		 productDao.updatepricedetails(pmo);
		
	}

	@Override
	public ProductModel getproductIdRow(Long productid) {
		return productDao.getproductIdRow(productid);
	}

	@Override
	public void updateStatus(ProductModel pmo) {
		productDao.updateStatus(pmo);
		
	}
	
}
