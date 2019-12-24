/**
 * 
 */
package com.rp.tech;

import java.util.List;

import org.apache.metamodel.UpdateableDataContext;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

/**
 * @author rajendra
 *
 */
public class SalesForceModelHandler {
	public void getModelDetails(UpdateableDataContext dataContext) {
		Schema defaultSchema = dataContext.getDefaultSchema();
		List<String> tableNames = defaultSchema.getTableNames();
		for (String salesForceObj : tableNames) {
			System.out.println(salesForceObj);
			Table table = defaultSchema.getTableByName(salesForceObj);
			List<Column> columns = table.getColumns();
			for (Column column : columns) {
				System.out.println("Column Number: "+column.getColumnNumber() +"\t "
						+ "Column Name: "+column.getName() +"\t "
								+ "Remark: "+column.getRemarks() +"\t "
								+ "Data type: "+column.getType().getName()+"\t "
										+ "JDBC Data type: "+column.getType().getJdbcType()+"\t "
										+ "Column Data type: "+column.getNativeType() + "\t");
			}
			
			
			
		}
		
		
		
	}
}
