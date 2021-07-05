package com.axelor.expense;

import com.axelor.app.AxelorModule;
import com.axelor.expense.service.PractiseRpcService;
import com.axelor.expense.service.PractiseRpcServiceImpl;

public class ExpenseTrackerModule extends AxelorModule{
	 @Override
	  protected void configure() {
	    bind(PractiseRpcService.class).to(PractiseRpcServiceImpl.class);
	  }
}
