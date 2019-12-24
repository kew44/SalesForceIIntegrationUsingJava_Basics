/**
 * 
 */
package com.rp.tech;

import java.util.List;

import org.apache.metamodel.MetaModelException;
import org.apache.metamodel.UpdateableDataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.schema.Table;

/**
 * @author rajendra
 *
 */
public class SalesForceOperationHandler {
	private UpdateableDataContext dataContext;

	public SalesForceOperationHandler(UpdateableDataContext dataContext)
	{
		this.dataContext =  dataContext;
	}
	
	public Object fetchData(String from, List<String> attributes, String whereClause)
	{
		
			try {
				Table source = dataContext.getDefaultSchema().getTableByName(from);
				
				String selectAttributes = String.join(",", attributes);
				 
				DataSet dataSet = dataContext.query().from(source).selectAll().execute();
				 
				while (dataSet.next()) {
				 Row row = dataSet.getRow();
				 System.out.println(row);
				/* Object id = row.getValue(0);
				 Object name = row.getValue(1);
				 System.out.println("Account '" + name + "' from New York has id: " + row.getValue(0));*/
				}
				dataSet.close();
			} catch (MetaModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		
	}

}
