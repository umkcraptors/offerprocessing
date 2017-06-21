package offerprocessing;

import com.businessintelli.offerprocessing.model.Marketer;

import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;

import com.businessintelli.offerprocessing.dao.*;

public class MarketerDaoTest {

	
	
	 public static void main(String[] args)
	{
//		Session session = MarketerDao.getSessionFactory().openSession();
//        session.beginTransaction();
		Marketer m = new Marketer();
		m.setDomain("Amazon");
		m.setMarketerType("Online");
		m.setName("Ram");
		m.setId(211);
		
		MarketerDao md = new MarketerDao();
		md.persist(m);
		
		
	}
}
