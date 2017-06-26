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
		m.setMarketertype("Phones");
		m.setName("Steve Jobs");

		try {
			dataServices.addMarketer(m);
		} catch (InsertFailedException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void updateMarketertest() {
		System.out.println("dataServices:" + dataServices);
		try {
			Marketer m = dataServices.getMarketer(17);
			m.setName("Walmart.com");
			dataServices.updateMarketer(m);
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteMarketertest() {
		try {
			dataServices.deleteMarketer(16);
		} catch (DeleteFailedException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveMarketertest() throws DeleteFailedException {
		try {
			dataServices.getMarketer(5);
		} catch (RetrieveFailedException e) {
			e.printStackTrace();
		}
	}
	

}
