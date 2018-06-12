package com.pub;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.NamingException;
//import javax.xml.ws.spi.Provider;

import com.citi.rio.registry.infra.Environment;
import com.citi.rio.registry.infra.Region;
import com.citi.rio.umb.UmbClientFactory;
import com.citi.rio.umb.payload.Payload.Key;
import com.citi.rio.umb.subscribe.UmbMessageHandler;
import com.citi.rio.umb.subscribe.UmbMessageHandlerFactory;
import com.citi.rio.umb.subscribe.UmbSubscriber;
import com.citi.rio.umb.subscribe.exception.MessageHandlerCreationException;

public class TopicConsumerTestDual implements MessageListener,
		ExceptionListener {

	public static void main(final String[] args) throws NamingException,
			JMSException, InterruptedException {

		System.out.println(" Main " + args);
//		UmbClientFactory ucf = new UmbClientFactory(Environment.UAT, Region.EMEA);
		UmbClientFactory ucf = new UmbClientFactory(Environment.UAT, Region.NAM);
//		UmbClientFactory ucf = new UmbClientFactory(Environment.UAT, Region.EMEA);
//		UmbClientFactory ucf = new UmbClientFactory(Environment.PRD, Region.NAM);

		// Provider p = null;
		UmbSubscriber<String> subscriber = ucf.createSubscriber(
//				"168480-SUB_168480.UNO-001",
//				"167902-SUB_FAILSAFE_EQ_QPB-001",
//				"146254-NAM_DSF_QPB_EMEA_TO_RIO_KDB-001",
//				"147273-SUB_ODAC_NA_CMMNRFQ_ARCHIVAL-001",
//				"34489-GEOTRADER-001",
//				"164560-CTRS-RIO-SUBSCRIBER-003",
//				"34489-GEOTRADER-001",
//				"147273-TEST_SUB_LC02019-001",
//				"147273-SUB_ODAC_NA_CIOI-001",
//				"170530-SUB_REGHUB_ANNA_TRADES_EMEA-001",
//				"32853-DDI_OTC_TRADE-005",
//				"147273-SUB_ODAC_DDI_OTC_TRADE-001",
//				"164122-RATESBONDPRICE_NAM_PNLSUB-001",
//				"154698-RATESBONDPRICE_SUB_NAM_PNL-001",
//				"164122-RATESBONDPRICE_NAM_PNLSUB-001",
				"168480-ATHENA_CREDIT_RFQ-001",
//				"170530-REGHUB_RTTM_MSRB_XML_SUB_GRP-002",
//				"163255-DREAM_PRIMO_TRADES-003",
// 				"147273-SUB_ODAC_SONAR_DEALER-001",
//				"149976-CWM_SWIFT_SUBSCRIBER-001",
// 				"147273-TEST_SUB_LC02019-005",
				new UmbMessageHandlerFactory<String>() {

					// ucf.createSubscriber("147273-147273-APP-ASTG-TST-JS-SUB-001",
					// new
					// UmbMessageHandlerFactory<String>() {
					//
					@Override
					public UmbMessageHandler<String> create(
							final Map<Key, Object> metaData)
							throws MessageHandlerCreationException {

						return new UmbMessageHandler<String>() {

							private long counter = 0;

							@Override
							public void onPayload(final String payload) {

								// processes the message here.
								System.out.println("***** Message " + counter++
										+ " : " + payload);

							}

							@Override
							public void onApplicationError(
									final String payload,
									final RuntimeException error) {

								// Handle Application Error

							}

							@Override
							public void onConnectionError(final Exception error) {

								// Handle Connection Error.

							}

						};

					}

				});

		try {
			TimeUnit.SECONDS.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// subscriber.
		TimeUnit.SECONDS.sleep(10000);
		subscriber.shutdown();

	}

	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

}
