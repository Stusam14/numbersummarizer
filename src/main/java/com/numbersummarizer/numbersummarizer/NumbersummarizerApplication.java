package com.numbersummarizer.numbersummarizer;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.numbersummarizer.numbersummarizer.Infrastructure.settings.InputSetting;
import com.numbersummarizer.numbersummarizer.common.NumberRange;

@SpringBootApplication
public class NumbersummarizerApplication {
	private static Logger log = LoggerFactory.getLogger(NumbersummarizerApplication.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(NumbersummarizerApplication.class, args);
		/*
		 * The code below runs the default string setup in properties file, you change the string 
		 * if you want to use your own then run the code again
		 */
		NumberRange numberRange = context.getBean(NumberRange.class);
		Collection<Integer> collected = numberRange.collect();


		/*
		 * if you want to override the default String settings, you can follow the following
		 * guide code below then you can run your code ,or remove the already available code 
		 * and put uour string that you want to sumarise.
		 */
		InputSetting inputSetting = new InputSetting();
		inputSetting.setSequenceString("0,20020,20021,5,70000000,1000001,1000002,1000003,20022,300200,300201,400000,400001,400002,4000000,5000,300,320,321,321,321,13949,1199,1211,1588,1600,150,1700,1700000,15,16,20");
		// inputSetting.setSequenceString("a,2,4,5,6,7,8,9,0,,3,b,c,d,d");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected2 = numberRange.collect();
		log.info("================================================================================================================================================================");
		log.info("Summarised Range: {}" , numberRange.summarizeCollection(collected));
		log.info("Summarised Range: {}" , numberRange.summarizeCollection(collected2));
		log.info("================================================================================================================================================================");


	}

}
