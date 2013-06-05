package model.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Categorie;
import model.services.IbatisService;

public class CategorieManager {

		public CategorieManager(){
			
		}
		
		@SuppressWarnings("unchecked")
		public List<Categorie> getAllCat(){
			
			List<Categorie> allCat = new ArrayList<Categorie>();
			
			try {
				allCat = IbatisService.getM_sqlMap().queryForList("getAllCat");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return allCat;
			
		}
		
		public int getNoCatByCategory(String CategoryDescription){
			int noCategory = 0;
			try {
				noCategory = (int) IbatisService.getM_sqlMap().queryForObject("getNoCatByCategory", CategoryDescription);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return noCategory;
			
		}
		
}
