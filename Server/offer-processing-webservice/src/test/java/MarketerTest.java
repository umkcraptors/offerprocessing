import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bizintelli.offerprocessing.dao.MarketerDAOImpl;
import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.exception.DeleteFailedException;
import com.bizintelli.offerprocessing.exception.InsertFailedException;
import com.bizintelli.offerprocessing.exception.RetrieveFailedException;
import com.bizintelli.offerprocessing.services.MarketerService;
import com.bizintelli.offerprocessing.services.MarketerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-jdbc.xml" })
public class MarketerTest {

	@Autowired(required = true)
	@Qualifier("marketerService")
	MarketerService dataServices;
	MarketerServiceImpl ms = new MarketerServiceImpl();
	MarketerDAOImpl md = new MarketerDAOImpl();
	Marketer m = new Marketer();

	@Test
	// @Transactional
	// @Rollback(true)
	public void insertMarketertest() {

		m.setDomain("Apple");
		//m.setMarketertype("Phones");
		m.setName("Steve Jobs");

		try {
			Marketer mrktr = dataServices.addMarketer(m);
			assertFalse(mrktr == null);
		} catch (InsertFailedException e) {

			e.printStackTrace();
			assertFalse(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertFalse(true);
		}

	}

	@Test
	public void updateMarketertest() {
		System.out.println("dataServices:" + dataServices);
		try {
			Marketer m = dataServices.getMarketer(17);
			m.setName("Walmart.com");
			dataServices.updateMarketer(m);
			assertFalse(m != null);
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteMarketertest() {
		try {
			boolean m;
			m=dataServices.deleteMarketer(13);
			assertTrue(m);
		} catch (DeleteFailedException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveMarketerNegTest() throws DeleteFailedException {
		try {
			Marketer mrktr = dataServices.getMarketer(5);
			System.out.println("Marketer:" + mrktr.getName() );
			assertFalse(mrktr != null && mrktr.getName().startsWith("amazon"));
						
		} catch (RetrieveFailedException e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}
	
	@Test
	public void retrieveMarketerNegTest1() throws DeleteFailedException {
		try {
			Marketer mrktr = dataServices.getMarketer(5);
			System.out.println("Marketer:" + mrktr.getName() );
			assertFalse(mrktr != null && mrktr.getName().startsWith("amazon"));
						
		} catch (RetrieveFailedException e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	@Test
	public void retrieveMarketertest() throws DeleteFailedException {
		try {
			Marketer mrktr = dataServices.getMarketer(5000);
			assertTrue(mrktr != null && mrktr.getName().startsWith("Patel"));
						
		} catch (RetrieveFailedException e) {
			e.printStackTrace();
			assertFalse(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			assertFalse(true);
		}
	}

}
