package com.rp.tech;

import java.util.Arrays;

import org.apache.metamodel.UpdateableDataContext;
import org.apache.metamodel.salesforce.SalesforceDataContext;

public class SalesForceIntegrationDemo {

	public static void main(String[] args) {
		
		SalesForceIntegrationDemo salesForceConnector = new SalesForceIntegrationDemo();
		UpdateableDataContext dataContext  = salesForceConnector.connect("your_email","password","SecurityToken");
		SalesForceModelHandler salesForceModelHandler = new SalesForceModelHandler();
		salesForceModelHandler.getModelDetails(dataContext);
		
		SalesForceOperationHandler salesForceOperationHandler = new SalesForceOperationHandler(dataContext);
		salesForceOperationHandler.fetchData("Account", Arrays.asList("Milan", 
                "London", 
                "New York", 
                "San Francisco"), null);
		
	}

	

	public UpdateableDataContext connect(String uname,String pward,String secTocken)
	{
		
		//	UpdateableDataContext dataContext = new SalesforceDataContext("foo", "bar", "baz");
		UpdateableDataContext dataContext = new SalesforceDataContext(uname,pward,secTocken);
		
		/*Table accountTable = dataContext.getDefaultSchema().getTableByName("Account");
		 
		DataSet dataSet = dataContext.query().from(accountTable).select("Id", "Name").where("BillingCity").eq("New York").execute();
		 
		while (dataSet.next()) {
		 Row row = dataSet.getRow();
		 Object id = row.getValue(0);
		 Object name = row.getValue(1);
		 System.out.println("Account '" + name + "' from New York has id: " + row.getValue(0));
		}
		dataSet.close();*/
		return dataContext;
	}
}
