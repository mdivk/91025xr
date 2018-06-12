package com.rx52019;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.rio.registry.infra.Environment;
import com.citi.rio.registry.infra.Region;
import com.citi.rio.umb.UmbClientFactory;
import com.citi.rio.umb.exception.UmbException;
import com.citi.rio.umb.publish.UmbPublisher;
//import com.test.TestPubEric;

public class TestPub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UmbClientFactory ucf = new UmbClientFactory(Environment.UAT, Region.NAM);

		UmbPublisher<String> publisher = null;

		Logger logger = LoggerFactory.getLogger(TestPub.class);

		try {

//		    publisher = ucf.createPublisher("162721-FXLM_FX_TML_PUBLISHER");
//		    publisher = ucf.createPublisher("150699-TPS_DERIV_CITIML-001");
//		    publisher = ucf.createPublisher("169791-CIOI-001");
//		    publisher = ucf.createPublisher("147273-TEST_PUB_LC02019-002");
//    	    publisher = ucf.createPublisher("162799-NAM-THOR-RFQ-001");
//    	    publisher = ucf.createPublisher("170530-REGHUB_RTTM_MSRB_RESPONSE-002");
//    	    publisher = ucf.createPublisher("157514-COMET_EMEA_RFQ-001");
//			publisher = ucf.createPublisher("32853-DDI_OTC_TRADE-005");
//			publisher = ucf.createPublisher("155104-RATESBONDPRICE-NAM-1");
//			publisher = ucf.createPublisher("155104-UKRATRFQFIX-001");
			publisher = ucf.createPublisher("162632-CREDIT_ETRADING_MIFID_RFQ-001");
			 
			
			 
    	    
		    publisher.publish("some message content from TestPub1");
		    publisher.publish("some message content from TestPub2");
		    publisher.publish("some message content from TestPub3");
		    
			logger.info("publisher some message successfully from TestPub");

		}

		catch (UmbException e) {

		    logger.error("Failed publishing a UMB Message.", e);

		}

		finally {

		    publisher.shutdown();
		    logger.info("publisher shutdown successfully");

		}

	}

}
