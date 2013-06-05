package model.services;

import java.io.IOException;
import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisService {
	
	private static SqlMapClient m_sqlMap;

	// Configuration du sqlMap
	static{
		// config xml
		String ressource = "model/services/sqlMapConfig.xml";
		System.out.println("dans ibatis service");
		try {
			Reader reader = Resources.getResourceAsReader(ressource);
			m_sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getM_sqlMap() {
		return m_sqlMap;
	}
}

