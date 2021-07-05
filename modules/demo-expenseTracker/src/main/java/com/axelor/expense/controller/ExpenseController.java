package com.axelor.expense.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.JpaSupport;
import com.axelor.expense.db.Expense;
import com.axelor.expense.db.repo.ExpenseRepository;
import com.axelor.expense.service.PractiseRpcService;
import com.axelor.meta.CallMethod;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ExpenseController extends JpaSupport {
	
	@Inject
	private PractiseRpcService service;
	
  @CallMethod
  public String getTag() {
    return "from tag-get :p";
  }

  @CallMethod
  public void checkMove() {
    System.out.println(
        "printing here for testing whether it is getting called or not in action method kanban on move");
    ;
    ExpenseRepository ep = new ExpenseRepository();

    Expense ex = ep.findByCategory("Basic");
    System.out.println(ex);
  }
  

  public void practiseRpc(ActionRequest request, ActionResponse response) {
//    System.out.println(
//        "printing here for testing whether it is getting called or not");
//    EntityManager em = getEntityManager();
//    Query q1 = em.createQuery(" SELECT distinct" + 
//    		"    _category.categoryName as category," + 
//    		"     sum(self.price) as totalPriceOfAllExpense" + 
//    		"    FROM" + 
//    		"        Expense self" + 
//    		"    inner join " + 
//    		"    self.category as _category" + 
//    		"    group by _category.categoryName");
//    
//    List<Object[]> l1 = q1.getResultList();
//    List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
//    for(Object[] item : l1) {
//        Map<String, Object> data = new HashMap<>();
//
//    	String ncat = (String)item[0];
//    	Long price = (Long)item[1];
//    	data.put("ncat", ncat);
//    	data.put("price", price);
//    	listdata.add(data);
//    	
//    }
    
//    List<?> l1 = q1.getResultList();
//  Map<String, Object> data = new HashMap<>();
//data.put("ncat", l1.get(0).get(0));
    List<Map<String,Object>> listdata = service.writeOneQuery();
    response.setData(listdata);
    
   
  }
}
