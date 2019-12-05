package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.ProductDAO;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.Product;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.util.HibernatePaginationCallback;
import com.sparity.shoppingcart.util.HibernatePaginationCallbackParams;
import com.sparity.shoppingcart.util.HibernatePaginationCallbackParamsList;
@Repository("productDAO")
public class ProductDAOImpl extends BaseDAOImpl implements ProductDAO {

	private static final Logger logger = Logger.getLogger(ProductDAOImpl.class.getName());
	

	// @Override
	public void save(Product product) {
		// this.getEntityManager().persist(product);
		saveObject(product);
	}
	
	public void delete(){
		///deleteObject(product);
	}
	
	public String displayProducts(){
		logger.info("in displayProducts++++++++" );
		System.out.println("inside saveObject of BaseDAOImpl+++++++++++++++");
		return "String";
	}
	
	public String compareProds(String item1,String item2){
	
	
	
		return "";
	}

	@Override
	public List<ProductModel> findAllProducts(int page,int rows) {
		
		/*Query query = getSession().createQuery("from Transaction as trans where trans.account=:username order by trans.tranDate desc");
		query.setParameter("username", userName);
		query.setFirstResult(page);
		query.setMaxResults(rows); from Transaction as trans where trans.account=:username order by trans.tranDate desc*/
		/*SessionFactory  sessionFactory= getHibernateTemplate().getSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ProductModel as prodModel");
		query.setFirstResult(page);
		query.setMaxResults(rows);
		
		return query.list();*/
		
		/*Query query = getSession().createQuery("from ProductModel as prodModel");
		query.setFirstResult(page);
		query.setMaxResults(rows);
		
		return query.list();*/
		
		return getHibernateTemplate().executeFind(new HibernatePaginationCallback("from ProductModel as prodModel",page,rows));
	}
	
	@Override
	public int countTransactions() {
		List<ProductModel> prodModeList=getHibernateTemplate().find("from ProductModel as prodModel");
		return prodModeList.size();
	}

	@Override
	public List<ProductModel> findSpecificBrandProds(Long brandId) {
		String queryString = "from ProductModel as product where product.brandModel.brandId = :brandId";
		//getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandId"}, new Object[]{brandId});
		List<ProductModel> specificBrandProds = getHibernateTemplate().findByNamedParam(queryString, "brandId", brandId);
		if(logger.isInfoEnabled()&& specificBrandProds!=null)
			logger.info("Brand products size "+specificBrandProds.size());
			return getHibernateTemplate().findByNamedParam(queryString, "brandId", brandId);
		 
	}

	@Override
	public List<Object> brandPriceRange(Long brandId) {
		
		String queryString = "select min(product.mrpPrice)as minprice,max(product.mrpPrice)as maxprice from ProductModel as product where product.brandModel.brandId = :brandId";
		List<Object> priceRange = getHibernateTemplate().findByNamedParam(queryString, "brandId", brandId);
		//List<Object> pRange = getHibernateTemplate().execute(new HibernatePriceRangeCallback(queryString,brandId));
		/*if(logger.isInfoEnabled()&& pRange!=null)
			logger.info("Brand products size "+pRange.size());*/
		return priceRange;
	}
// i wrote methods
	@Override
	public List<ProductModel> priceRangeProducts(Double minPrice,
			Double maxPrice,Long brandId) {
		logger.info("price ranges are"+minPrice +   " and"  +maxPrice +"and " +brandId );
		List<ProductModel> rangeProducts = getHibernateTemplate().findByNamedParam("from ProductModel as pm  where  pm.mrpPrice   between  :minPrice and  :maxPrice and  pm.brandModel.brandId=:brandId", new String[]{"minPrice","maxPrice","brandId"}, new Object[]{minPrice,maxPrice,brandId});
		logger.info("pm size...."+rangeProducts.size());
		return rangeProducts;
	}
	
	@Override
	public List<ProductTypeModel> getProductTypes() {
		logger.info("inside getProductTypes");
		String queryString = "from ProductTypeModel  as ptm";
		return getHibernateTemplate().find(queryString);
	}
	@Override
	public List<BrandModel> getBrands() {
		logger.info("inside getBrands");
		String queryString = "from BrandModel bm";
		return getHibernateTemplate().find(queryString);
	}
	
	@Override
	public List<ProductModel> getAllCategoryProds(Long categoryId) {
		
		logger.info("categoryId is======="+categoryId);
		String queryString = "from ProductModel as pm where  pm.prodTypeModel.categoryModel.categoryId=:categoryId  order by pm.mrpPrice" ;
		List<ProductModel> prod=getHibernateTemplate().findByNamedParam(queryString, "categoryId", categoryId);
		if(logger.isInfoEnabled())
		logger.info("getAllCategoryProds size: "+prod.size());
		return prod;
	}

	
	public List<ProductTypeModel> getCategoryTypes(Long categoryId){
		
		String queryString = "from ProductTypeModel as ptm where  ptm.categoryModel.categoryId=:categoryId " ;
		return getHibernateTemplate().findByNamedParam(queryString, "categoryId", categoryId);
	}

	@Override
	public List<BrandModel> getMobileBrands(Long categoryId) {
		String queryString = "from BrandModel as bm where  bm.categoryModel.categoryId=:categoryId";
		return getHibernateTemplate().findByNamedParam(queryString, "categoryId", categoryId);
	}
	
	@Override
	public List<ProductModel> getProductTypes(Long prodTypeId,int page, int rows){
		logger.info("inside getProductTypes" +prodTypeId);
		String queryString = "from ProductModel as pm where  pm.prodTypeModel.prodTypeId=:prodTypeId";
		//return getHibernateTemplate().findByNamedParam(queryString, "prodTypeId", prodTypeId);
		String[] pramNames= new String[]{"prodTypeId"};
		Object[] pramValues= new Object[]{prodTypeId};
		List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParams(queryString,page,rows,pramNames,pramValues));
		if(logger.isInfoEnabled())
			logger.info("getAllCategoryProds size: "+products.size());
		if(products!=null && products.size()>0){
			return products;
		} else {
			return null;
		}
	}

	@Override
	public List<ProductModel> getProductTypes(Long prodTypeId, Long brandId) {
		logger.info("inside getProductTypes" +prodTypeId+ " "+brandId);
		
		if(prodTypeId!=null && brandId==null){
			String queryString = "from ProductModel as pm where pm.prodTypeModel.prodTypeId=:prodTypeId" ;
			return getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeId"}, new Object[]{prodTypeId});
		} else {
			String queryString = "from ProductModel as pm where pm.prodTypeModel.prodTypeId=:prodTypeId and pm.brandModel.brandId=:brandId order by pm.mrpPrice" ;
			return getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeId","brandId"}, new Object[]{prodTypeId,brandId});
		}
		
		}

	@Override
public List<ProductModel> selectMultilpleBrandProdIds(List<Long> prodTypeIdList,
			List<Long> brandIdList,Double minPrice,Double maxPrice) {
		logger.info("inside prodtype id not null "+prodTypeIdList.size());
		logger.info("inside brandId id not null "+brandIdList.size());
		
		if(prodTypeIdList.size()>0 && brandIdList.size()==0 ){
			logger.info("inside prodtype id not null "+prodTypeIdList.size());
		String queryString="from ProductModel pm where  pm.prodTypeModel.prodTypeId IN (:prodTypeIdList) and  pm.mrpPrice between  :minPrice and  :maxPrice order by pm.mrpPrice asc";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeIdList","minPrice","maxPrice"}, new Object[]{prodTypeIdList,minPrice,maxPrice});
	}
	
		if(brandIdList.size()>0 && prodTypeIdList.size()>0){
		logger.info("inside prodtype id not null "+brandIdList.size());
		String queryString="from ProductModel pm where pm.prodTypeModel.prodTypeId IN (:prodTypeIdList) and   pm.brandModel.brandId  in (:brandIdList)  order by pm.mrpPrice asc";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeIdList","brandIdList"}, new Object[]{prodTypeIdList,brandIdList});
	}
	if(prodTypeIdList.size()==0 && brandIdList.size()>0 ){
		logger.info("inside prodtype id not null "+brandIdList.size());
		String queryString="from ProductModel pm where   pm.brandModel.brandId  in (:brandIdList) and  pm.mrpPrice between  :minPrice and  :maxPrice  order by pm.mrpPrice asc";
		List<ProductModel> prod=getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandIdList","minPrice","maxPrice"}, new Object[]{brandIdList,minPrice,maxPrice});
     logger.info("size ===========is "+prod.size());
	return prod;
	}
	
	return null;
}
	@Override
	public List<ProductModel> findAllProductsHomePage() {
		return getHibernateTemplate().find("from ProductModel as prodModel");
	}
	@Override
	public List<ProductModel> findDataOfCheckBox(List<Long> gridCompare) {
		
		logger.info("inside findDataOfCheckBox of daoimpl "+gridCompare.size());
		String queryString ="from ProductModel as prodModel where prodModel.productId in (:comparelist)";
		List<ProductModel> compareProds = getHibernateTemplate().findByNamedParam(queryString, new String[]{"comparelist"}, new Object[]{gridCompare});
		if(logger.isInfoEnabled()&& compareProds!=null)
			logger.info("Compare Prod Size "+compareProds.size());
			return compareProds;
	}
	/*@Override
	public String compareProds(String item1, String item2) {
		
		return null;
	}*/

	@Override
	public int getCountForCategoryProducts(Long categoryId) {
		//String queryString ="select count(prodModel.productId)from ProductModel as prodModel, ProductTypeModel as prodType where prodType.prodTypeId = :categoryId and prodModel.prodTypeModel.prodTypeId = prodType.prodTypeId";
		String queryString ="select count(prodModel.productId)from ProductModel as prodModel, ProductTypeModel as prodType where prodType.categoryModel.categoryId = :categoryId and prodModel.prodTypeModel.prodTypeId = prodType.prodTypeId";
		List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, "categoryId", categoryId);
		if(logger.isInfoEnabled())
			logger.info("getCountForCategoryProducts Count "+counts.size());
		if(counts!=null&&counts.size()>0){
			Long count = (Long)counts.get(0);
			logger.info("getCountForCategoryProducts value "+count.intValue());
			return (int)count.intValue();
		} else {
			return 0;
		}
		
	}

	@Override
	public List<ProductModel> getAllCategoryProds(Long categoryId, int page,
			int rows) {
		String queryString ="from ProductModel as pm where  pm.prodTypeModel.categoryModel.categoryId=:categoryId  order by pm.mrpPrice";
		String[] pramNames= new String[]{"categoryId"};
		Object[] pramValues= new Object[]{categoryId};
		List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParams(queryString,page,rows,pramNames,pramValues));
		if(logger.isInfoEnabled())
			logger.info("getAllCategoryProds size: "+products.size());
		if(products!=null && products.size()>0){
			return products;
		} else {
			return null;
		}
	}
	
	

	@Override
	public int getCountForBrandCategoryProducts(Long categoryId, Long brandId) {
		String queryString ="select count(prodModel.productId)from ProductModel as prodModel, ProductTypeModel as prodType where prodType.categoryModel.categoryId = :categoryId and prodModel.brandModel.brandId= :brandId and prodModel.prodTypeModel.prodTypeId = prodType.prodTypeId";
		List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"categoryId","brandId"}, new Object[]{categoryId,brandId});
		if(logger.isInfoEnabled())
			logger.info("getCountForBrandCategoryProducts Count "+counts.size());
		if(counts!=null&&counts.size()>0){
			Long count = (Long)counts.get(0);
			logger.info("getCountForBrandCategoryProducts value "+count.intValue());
			return (int)count.intValue();
		} else {
			return 0;
		}
	}

	
	@Override
	public List<ProductModel> getBrandCategoryProds(Long categoryId,
			Long brandId, int page, int rows) {
		String queryString ="from ProductModel as product where product.prodTypeModel.categoryModel.categoryId = :categoryId and product.brandModel.brandId = :brandId order by product.mrpPrice";
		String[] pramNames= new String[]{"categoryId","brandId"};
		Object[] pramValues= new Object[]{categoryId,brandId};
		List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParams(queryString,page,rows,pramNames,pramValues));
		if(logger.isInfoEnabled())
			logger.info("getBrandCategoryProds size: "+products.size());
		if(products!=null && products.size()>0){
			return products;
		} else {
			return null;
		}
	}

	@Override
	public int getCountForProdTypes(Long prodTypeId) {
		String queryString ="select count(pm.productId) from ProductModel as pm where  pm.prodTypeModel.prodTypeId=:prodTypeId";
		List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, "prodTypeId", prodTypeId);
		if(logger.isInfoEnabled())
			logger.info("getCountForProdTypes Count "+counts.size());
		if(counts!=null&&counts.size()>0){
			Long count = (Long)counts.get(0);
			logger.info("getCountForProdTypes value "+count.intValue());
			return (int)count.intValue();
		} else {
			return 0;
		}
	}

	@Override
	public int productTypeBrandsCount(List<Long> prodTypeId, List<Long> brandId, Long categoryId, Double minPrice,Double maxPrice) {
		//only producttype selection count
		if(prodTypeId!=null && prodTypeId.size()>0 && (brandId ==null || brandId.size()==0 )){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId)";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, "prodTypeId", prodTypeId);
			if(logger.isInfoEnabled())
				logger.info("productTypeBrandsCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypeBrandsCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		}
		//producttype and prices....
		else if(prodTypeId!=null && prodTypeId.size()>0 && (brandId ==null || brandId.size()==0 )&& (minPrice !=null || maxPrice!=null )){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.mrpPrice between :minPrice and :maxPrice";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeId","minPrice","maxPrice"}, new Object[]{prodTypeId,minPrice,maxPrice});
			if(logger.isInfoEnabled())
				logger.info("productTypeBrandsCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypeBrandsCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		}
		// only brand selection count
		else if((brandId!=null && brandId.size()>0) && (prodTypeId ==null || prodTypeId.size()==0 ) && categoryId!=null){
			String queryString ="select count(pm.productId) from ProductModel as pm where pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.categoryModel.categoryId = :categoryId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandId","categoryId"}, new Object[]{brandId,categoryId});
			if(logger.isInfoEnabled())
				logger.info("productTypeBrandsCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypeBrandsCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		}
		//only brand and prices...
		else if((brandId!=null && brandId.size()>0) && (prodTypeId ==null || prodTypeId.size()==0 ) && categoryId!=null && (minPrice !=null || maxPrice!=null )){
			String queryString ="select count(pm.productId) from ProductModel as pm where pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.categoryModel.categoryId = :categoryId and pm.mrpPrice between :minPrice and :maxPrice";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandId","categoryId","minPrice","maxPrice"}, new Object[]{brandId,categoryId,minPrice,maxPrice});
			if(logger.isInfoEnabled())
				logger.info("productTypeBrandsCount brand prices Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypeBrandsCount brand prices value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		}
		
		//brand  producttype and prices selection count
		
		else if((prodTypeId!=null && prodTypeId.size()>0) && ((brandId!=null && brandId.size()>0) && categoryId!=null)&& (minPrice !=null || maxPrice!=null )){
			String queryString ="select count(pm.productId) from ProductModel as pm where pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.prodTypeModel.categoryModel.categoryId = :categoryId and pm.mrpPrice between :minPrice and :maxPrice";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandId","prodTypeId","categoryId","minPrice","maxPrice"}, new Object[]{brandId,prodTypeId,categoryId,minPrice,maxPrice});
			if(logger.isInfoEnabled())
				logger.info("productTypeBrandsCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypeBrandsCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} else {
			return 0;
		}
		
		
	}

	@Override
	public List<ProductModel> getProdsFromProdTypeAndBrands(
			List<Long> prodTypeId, List<Long> brandId, Long categoryId,
			int page, int rows, Double minPrice,Double maxPrice) {
		if(prodTypeId!=null && prodTypeId.size()>0 && (brandId ==null || brandId.size()==0 )&&(minPrice ==null || maxPrice==null)){
			String queryString ="from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId) order by pm.mrpPrice";
			String[] pramNames= new String[]{"prodTypeId"};
			Object[] pramValues= new Object[]{prodTypeId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdTypeAndBrands size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		}else if(prodTypeId!=null && prodTypeId.size()>0 && (minPrice !=null || maxPrice!=null )&& (brandId ==null || brandId.size()==0 )){
			String queryString ="from ProductModel as prodModel where prodModel.prodTypeModel.prodTypeId in(:prodTypeId) and prodModel.mrpPrice between :minPrice and :maxPrice order by prodModel.mrpPrice";
			String[] pramNames= new String[]{"prodTypeId","minPrice","maxPrice"};
			Object[] pramValues= new Object[]{prodTypeId,minPrice,maxPrice};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdTypeAndBrands prodtypes, prices size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		}else if((brandId!=null && brandId.size()>0) && (prodTypeId ==null || prodTypeId.size()==0 ) && categoryId!=null &&(minPrice ==null || maxPrice==null)){
			String queryString ="from ProductModel as pm where pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.categoryModel.categoryId = :categoryId order by pm.mrpPrice";
			String[] pramNames= new String[]{"brandId","categoryId"};
			Object[] pramValues= new Object[]{brandId,categoryId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdTypeAndBrands size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		} else if((brandId!=null && brandId.size()>0) && (prodTypeId ==null || prodTypeId.size()==0 ) && categoryId!=null && (minPrice !=null || maxPrice!=null )){
			String queryString ="from ProductModel as pm where pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.categoryModel.categoryId = :categoryId and pm.mrpPrice between :minPrice and :maxPrice order by pm.mrpPrice";
			String[] pramNames= new String[]{"brandId","categoryId","minPrice","maxPrice"};
			Object[] pramValues= new Object[]{brandId,categoryId,minPrice,maxPrice};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdTypeAndBrands brand and prices size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		}else if((prodTypeId!=null && prodTypeId.size()>0) && ((brandId!=null && brandId.size()>0) && categoryId!=null) && (minPrice !=null || maxPrice!=null )){
			String queryString ="from ProductModel as pm where pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.prodTypeModel.categoryModel.categoryId = :categoryId and pm.mrpPrice between :minPrice and :maxPrice order by pm.mrpPrice";
			String[] pramNames= new String[]{"brandId","prodTypeId","categoryId","minPrice","maxPrice"};
			Object[] pramValues= new Object[]{brandId,prodTypeId,categoryId,minPrice,maxPrice};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdTypeAndBrands size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		} else {
			//all are null redirect to all category products action...
			return null;
		}
	}

	@Override
	public List<Object> getMinAndMaxPriceForProducts(Long categoryId,Long brandId,Long prodTypeId) {
		
		String queryString=null;
		String[]paramNames = null;
		Object[]paramValues = null;
		
		if((categoryId!=null)&&(brandId==null && prodTypeId==null)){
			 queryString = "select min(product.mrpPrice),max(product.mrpPrice) from ProductModel as product where product.prodTypeModel.categoryModel.categoryId = :categoryId";
			 paramNames = new String[]{"categoryId"};
			 paramValues = new Object[]{categoryId};
		} else if((categoryId!=null && brandId!=null) && (prodTypeId==null)){
			 queryString = "select min(product.mrpPrice),max(product.mrpPrice) from ProductModel as product where product.brandModel.brandId = :brandId and product.prodTypeModel.categoryModel.categoryId = :categoryId";
			 paramNames = new String[]{"brandId","categoryId"};
			 paramValues = new Object[]{brandId,categoryId};
		} else if(categoryId!=null && brandId!=null && prodTypeId!=null){
			 queryString = "select min(product.mrpPrice),max(product.mrpPrice) from ProductModel as product where product.brandModel.brandId = :brandId and product.prodTypeModel.categoryModel.categoryId = :categoryId and product.prodTypeModel.prodTypeId= :prodTypeId" ;
			 paramNames = new String[]{"brandId","categoryId","prodTypeId"};
			 paramValues = new Object[]{brandId,categoryId,prodTypeId};
		} else if(categoryId==null && brandId==null && prodTypeId!=null){
			 queryString = "select min(product.mrpPrice),max(product.mrpPrice) from ProductModel as product where  product.prodTypeModel.prodTypeId= :prodTypeId" ;
			 paramNames = new String[]{"prodTypeId"};
			 paramValues = new Object[]{prodTypeId};
		}
		
		else {
			return null;
		}
		List<Object> priceRange = getHibernateTemplate().findByNamedParam(queryString, paramNames, paramValues);
		if(logger.isInfoEnabled()&& priceRange!=null)
			logger.info("getMinAndMaxPriceForProducts size "+priceRange.size());
		return priceRange;
	}

	@Override
	public int getProductPriceRangeCount(Double minPrice, Double maxPrice,
			Long categoryId) {
		String queryString ="select count(prodModel.productId)from ProductModel as prodModel where prodModel.mrpPrice between :minPrice and :maxPrice and prodModel.prodTypeModel.categoryModel.categoryId = :categoryId order by prodModel.mrpPrice";
		List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"minPrice","maxPrice","categoryId"}, new Object[]{minPrice,maxPrice,categoryId});
		if(logger.isInfoEnabled())
			logger.info("getProductPriceRangeCount Count "+counts.size());
		if(counts!=null&&counts.size()>0){
			Long count = (Long)counts.get(0);
			logger.info("getProductPriceRangeCount value "+count.intValue());
			return (int)count.intValue();
		} else {
			return 0;
		}
	}

	@Override
	public List<ProductModel> getPriceRangeProducts(Long categoryId, Double minPrice, Double maxPrice,int page,
			int rows) {
		String queryString ="from ProductModel as prodModel where prodModel.mrpPrice between :minPrice and :maxPrice and prodModel.prodTypeModel.categoryModel.categoryId = :categoryId";
		String[] pramNames= new String[]{"minPrice","maxPrice","categoryId"};
		Object[] pramValues= new Object[]{minPrice,maxPrice,categoryId};
		List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParams(queryString,page,rows,pramNames,pramValues));
		if(logger.isInfoEnabled())
			logger.info("getPriceRangeProducts size: "+products.size());
		if(products!=null && products.size()>0){
			return products;
		} else {
			return null;
		}
	}

	@Override
	public int productTypesCount(List<Long> prodTypeId, Long brandId, Long categoryId, Double minPrice, Double maxPrice) {
		// only producttypes filter... 
		if((prodTypeId!=null && prodTypeId.size()>0) && brandId !=null && (minPrice ==null || maxPrice==null)){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.brandModel.brandId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeId","brandId"}, new Object[]{prodTypeId,brandId});
			if(logger.isInfoEnabled())
				logger.info("productTypesCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypesCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} 
		// only prices filter...
		else if((minPrice !=null || maxPrice!=null) && (prodTypeId == null || prodTypeId.size()==0) && brandId !=null && categoryId!=null ){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.mrpPrice between :minPrice and :maxPrice and pm.brandModel.brandId =:brandId and pm.prodTypeModel.categoryModel.categoryId = :categoryId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"minPrice","maxPrice","brandId","categoryId"}, new Object[]{minPrice,maxPrice,brandId,categoryId});
			if(logger.isInfoEnabled())
				logger.info("productTypesCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypesCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} 
		// for prodtypes and prices and brand filter...
		else if((minPrice !=null || maxPrice!=null) && (prodTypeId!=null && prodTypeId.size()>0) && brandId !=null ){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.mrpPrice between :minPrice and :maxPrice and pm.brandModel.brandId =:brandId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"prodTypeId","minPrice","maxPrice","brandId"}, new Object[]{prodTypeId,minPrice,maxPrice,brandId});
			if(logger.isInfoEnabled())
				logger.info("productTypesCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypesCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public List<ProductModel> getProdsFromProdType(List<Long> prodTypeId,
			Long brandId, Long categoryId, int page, int rows, Double minPrice,
			Double maxPrice) {
		if((prodTypeId!=null && prodTypeId.size()>0) && brandId !=null && (minPrice ==null || maxPrice==null)){
			String queryString ="from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.brandModel.brandId";
			String[] pramNames= new String[]{"prodTypeId"};
			Object[] pramValues= new Object[]{prodTypeId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdType size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		}else if((minPrice !=null || maxPrice!=null) && (prodTypeId == null || prodTypeId.size()==0) && brandId !=null && categoryId!=null ){
			String queryString ="from ProductModel as pm where  pm.mrpPrice between :minPrice and :maxPrice and pm.brandModel.brandId =:brandId and pm.prodTypeModel.categoryModel.categoryId = :categoryId";
			String[] pramNames= new String[]{"minPrice","maxPrice","brandId","categoryId"};
			Object[] pramValues= new Object[]{minPrice,maxPrice,brandId,categoryId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdType size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		} else if((minPrice !=null || maxPrice!=null) && (prodTypeId!=null && prodTypeId.size()>0) && brandId !=null ){
			String queryString ="from ProductModel as pm where  pm.prodTypeModel.prodTypeId in(:prodTypeId) and pm.mrpPrice between :minPrice and :maxPrice and pm.brandModel.brandId =:brandId";
			String[] pramNames= new String[]{"prodTypeId","minPrice","maxPrice","brandId"};
			Object[] pramValues= new Object[]{prodTypeId,minPrice,maxPrice,brandId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromProdType size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		}
		
		else {
			return null;
		}
	}

	@Override
	public int brandsCount(Long prodTypeId, List<Long> brandId,
			Long categoryId, Double minPrice, Double maxPrice) {
		// only brands filter... 
		if((prodTypeId!=null) && (brandId !=null && brandId.size()>0) && (minPrice ==null || maxPrice==null)){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.prodTypeId and pm.prodTypeModel.categoryModel.categoryId=:categoryId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandId","categoryId"}, new Object[]{brandId,categoryId});
			if(logger.isInfoEnabled())
				logger.info("productTypesCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypesCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} 
		// only prices filter...
		else if((minPrice !=null || maxPrice!=null) && (brandId  == null || brandId.size()==0) && prodTypeId!=null){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.mrpPrice between :minPrice and :maxPrice and pm.prodTypeModel.prodTypeId =:prodTypeId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"minPrice","maxPrice","prodTypeId"}, new Object[]{minPrice,maxPrice,prodTypeId});
			if(logger.isInfoEnabled())
				logger.info("productTypesCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypesCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} 
		// for prodtypes and prices and brand filter...
		else if((minPrice !=null || maxPrice!=null) && (brandId!=null && brandId.size()>0) && prodTypeId !=null ){
			String queryString ="select count(pm.productId) from ProductModel as pm where  pm.brandModel.brandId in(:brandId) and pm.mrpPrice between :minPrice and :maxPrice and pm.prodTypeModel.prodTypeId =:prodTypeId";
			List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, new String[]{"brandId","minPrice","maxPrice","prodTypeId"}, new Object[]{brandId,minPrice,maxPrice,prodTypeId});
			if(logger.isInfoEnabled())
				logger.info("productTypesCount Count "+counts.size());
			if(counts!=null&&counts.size()>0){
				Long count = (Long)counts.get(0);
				logger.info("productTypesCount value "+count.intValue());
				return (int)count.intValue();
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public List<ProductModel> getProdsFromBrands(Long prodTypeId,
			List<Long> brandId, Long categoryId, int page, int rows,
			Double minPrice, Double maxPrice) {
		if( (brandId !=null && brandId.size()>0) && (minPrice ==null || maxPrice==null) && prodTypeId!=null){
			String queryString ="from ProductModel as pm where  pm.brandModel.brandId in(:brandId) and pm.prodTypeModel.prodTypeId and pm.prodTypeModel.categoryModel.categoryId=:categoryId";
			String[] pramNames= new String[]{"brandId","categoryId"};
			Object[] pramValues= new Object[]{brandId,categoryId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromBrands size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
		}else if((minPrice !=null || maxPrice!=null) && (brandId  == null || brandId.size()==0) && prodTypeId!=null){
			String queryString ="from ProductModel as pm where  pm.mrpPrice between :minPrice and :maxPrice and pm.prodTypeModel.prodTypeId =:prodTypeId";
			String[] pramNames= new String[]{"minPrice","maxPrice","prodTypeId"};
			Object[] pramValues= new Object[]{minPrice,maxPrice,prodTypeId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromBrands size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
			
		} else if((minPrice !=null || maxPrice!=null) && (brandId!=null && brandId.size()>0) && prodTypeId !=null ){
			String queryString ="from ProductModel as pm where  pm.brandModel.brandId in(:brandId) and pm.mrpPrice between :minPrice and :maxPrice and pm.prodTypeModel.prodTypeId =:prodTypeId";
			String[] pramNames= new String[]{"brandId","minPrice","maxPrice","prodTypeId"};
			Object[] pramValues= new Object[]{brandId,minPrice,maxPrice,prodTypeId};
			List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParamsList(queryString,page,rows,pramNames,pramValues));
			if(logger.isInfoEnabled())
				logger.info("getProdsFromBrands size: "+products.size());
			if(products!=null && products.size()>0){
				return products;
			} else {
				return null;
			}
			
		}else {
			return null;
		}
	}

	@Override
	public List<ProductModel> getAllBrandProds(Long categoryId, Long brandId) {
		String queryString = "from ProductModel as pm where pm.prodTypeModel.categoryModel.categoryId=:categoryId and pm.brandModel.brandId=:brandId" ;
		List<ProductModel> products = getHibernateTemplate().findByNamedParam(queryString, new String[]{"categoryId","brandId"}, new Object[]{categoryId,brandId});
		if(logger.isInfoEnabled())
			logger.info("getAllBrandProds size: "+products.size());
		if(products!=null && products.size()>0){
			return products;
		} else {
			return null;
		}
	}
	
	
	@Override
	public void updatepricedetails(ProductModel pmo) {
		logger.info("inside product dao impl mrp price"+pmo.getMrpPrice());
		logger.info("inside product dao impl offer price"+pmo.getOfferPrice());
		logger.info("inside product dao impl offer price"+pmo.getProductId());
		getHibernateTemplate().update(pmo);
		
		
	}

	@Override
	public ProductModel getproductIdRow(Long productid) {
		String queryString="from ProductModel as pm where pm.productId=:productid";
		
		List<ProductModel> pmlist=getHibernateTemplate().findByNamedParam(queryString, "productid", productid);
		return pmlist.get(0);
	}

	@Override
	public void updateStatus(ProductModel pmo) {
		getHibernateTemplate().update(pmo);
		
	}

	
}


