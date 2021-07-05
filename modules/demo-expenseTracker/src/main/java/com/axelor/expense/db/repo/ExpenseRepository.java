package com.axelor.expense.db.repo;

import com.axelor.expense.db.Expense;
import java.util.Map;

public class ExpenseRepository extends AbstractExpenseRepository {

  @Override
  public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
    if (!context.containsKey("json-enhance")) {
      return json;
    }
    try {
      Long id = (Long) json.get("id");
      Expense expense = find(id);
      json.put("address", expense.getCategory());
      json.put("hasImage", expense.getDate1() != null);
    } catch (Exception e) {
    }

    return json;
  }
  
  @Override
	public Expense copy(Expense entity, boolean deep) {
	  Expense copy = super.copy(entity, deep);
	  copy.setPrice(10000);
		return copy;
	}
  
  @Override
	public Expense save(Expense entity) {
	  Expense save = super.save(entity);
	  save.setExpense("preset name");
		return save;
	}
}
