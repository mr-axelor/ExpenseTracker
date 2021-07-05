package com.axelor.expense.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.JpaSupport;

public class PractiseRpcServiceImpl extends JpaSupport implements PractiseRpcService {

	public List<Map<String,Object>> writeOneQuery(){
		   System.out.println(
			        "printing here for testing whether it is getting called or not");
			    EntityManager em = getEntityManager();
			    Query q1 = em.createQuery(" SELECT distinct" + 
			    		"    _category.categoryName as category," + 
			    		"     sum(self.price) as totalPriceOfAllExpense" + 
			    		"    FROM" + 
			    		"        Expense self" + 
			    		"    inner join " + 
			    		"    self.category as _category" + 
			    		"    group by _category.categoryName");
			    
			    List<Object[]> l1 = q1.getResultList();
			    List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
			    for(Object[] item : l1) {
			        Map<String, Object> data = new HashMap<>();

			    	String ncat = (String)item[0];
			    	Long price = (Long)item[1];
			    	data.put("ncat", ncat);
			    	data.put("price", price);
			    	listdata.add(data);
			    	
			    }
			    return listdata;
	}
}
