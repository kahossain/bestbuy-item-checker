package com.zahidhossain;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@Component
public class Application implements HealthIndicator, HealthContributor {

	private static final String _3215129014_TXT_ATT_NET = "3215129014@txt.att.net";
        private static final Logger log = LoggerFactory.getLogger(Application.class);
	private static final String BESTBUY_API = "https://api.bestbuy.com/v1/products(sku in (6429440,6429442,6439402,6438278,6436191,6444449))?apiKey=qhqws47nyvgze2mq3qx4jadt&sort=onlineAvailability.asc&show=onlineAvailability,condition,sku,name,url,addToCartUrl&format=json";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private JavaMailSender emailSender;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) throws MessagingException {
		return builder.build();
	}

	@Scheduled(fixedRate = 60000)
        @Override
        public Health health() {
            
            try {
                Root root = restTemplate.getForObject(BESTBUY_API, Root.class);
                log.info("Checking... Total Time: " + root.getTotalTime());
                List<Product> products = root.getProducts();

                for (Product product : products) {
                        if (product.isOnlineAvailability()) {
                                log.info("Match found sending email.....");
                                sendemail(product);
                                log.info("Email Sent.");
                        }
                }
                return Health.up().build();
            } catch (Exception ex) {
                return Health.down(ex).build();
            }
        }
	
	@Bean
	public String init() throws MessagingException {
	    sendemail("Application Started", "Enjoy");
	    return "Success";
	}

	public void sendemail(Product product) throws MessagingException {

		try {

			MimeMessage message = emailSender.createMimeMessage();

			message.setSubject("Nvidia RTX available");
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(new InternetAddress("noreply@zahidhossain.com"));
			helper.setTo(_3215129014_TXT_ATT_NET);
			helper.setText(product.getName() + "<br>" + product.getUrl() + "<br>" + product.getAddToCartUrl(), true);
			emailSender.send(message);
		} catch (MessagingException ex) {

			throw ex;

		}
	}
	
	public void sendemail(String subject, String text) throws MessagingException {
	    
	    try {
	        
	        MimeMessage message = emailSender.createMimeMessage();
	        
	        message.setSubject(subject);
	        MimeMessageHelper helper;
	        helper = new MimeMessageHelper(message, true);
	        helper.setFrom(new InternetAddress("noreply@zahidhossain.com"));
	        helper.setTo(_3215129014_TXT_ATT_NET);
	        helper.setText(text, true);
	        emailSender.send(message);
	    } catch (MessagingException ex) {
	        
	        throw ex;
	        
	    }
	}
}
