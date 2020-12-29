package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.dao.ShopDao;
import vcampus.server.dao.ShopDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.ProductInformation;
import vcampus.vo.ProductPurchase;

public class ShopServiceDaoImpl implements ShopServiceDao{
	
	private ShopDao sd = new ShopDaoImpl();
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID) {
		// TODO Auto-generated method stub
		if(sd.queryAccountCurrentByProductID(productID) != null) {
			return sd.queryAccountCurrentByProductID(productID);
		}
		return null;
	}
	
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByUserID(String userID) {
		// TODO Auto-generated method stub
		if(sd.queryAccountCurrentByUserID(userID) != null) {
			return sd.queryAccountCurrentByUserID(userID);
		}
		return null;
	}
	
	
	@Override
	public ArrayList<ProductInformation> queryAllProduct() {
		// TODO Auto-generated method stub
		if(sd.queryAllProduct() != null) {
			return sd.queryAllProduct();
		}
		return null;
	}
	
	
	
	@Override
	public ProductInformation queryProductInformation(String productID) {
		// TODO Auto-generated method stub
		if(sd.queryProductInformation(productID) != null) {
			return sd.queryProductInformation(productID);
		}
		return null;
	}
	
	
	@Override
	public boolean buyProduct(ProductPurchase buyProduct, int type)
			throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if(sd.buyProduct(buyProduct, type)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
	@Override
	public boolean addProductByAdmin(ProductInformation product) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(sd.addProductByAdmin(product)) {
				return true;
			}
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean updateProductByAdmin(ProductInformation product) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(sd.updateProductByAdmin(product)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return false;
	}
	
	
	@Override
	public boolean deleteProductByAdmin(String productID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(sd.deleteProductByAdmin(productID)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
}
