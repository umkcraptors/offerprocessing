import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bizintelli.offerprocessing.entity.Marketer;
import com.bizintelli.offerprocessing.services.MarketerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-jdbc.xml"})
public class MarketerTest {

	@Autowired(required=true)
	@Qualifier("marketerService")
	MarketerService dataServices;
	
	@Test
	public void test() {

		System.out.println("dataServices:" + dataServices);
		try {
			Marketer m = dataServices.getMarketer(200l);
			m.setName("Walmart.com");
			dataServices.updateMarketer(m);
			System.out.println(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
