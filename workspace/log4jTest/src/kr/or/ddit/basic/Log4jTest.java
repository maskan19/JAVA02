package kr.or.ddit.basic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {

	// Logger 클래스의 인스턴스를 받아온다.
	private static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
//		로그 기록을 남기는 메서드는 로그 레벨과 1대1로 대응이 되는 메서드를 제공한다.
//		
//		형식1) logger객체 변수.로그 레벨 메서드("출력할 메시지");
//		메서드별 로그레벨 : trace < debug < info < warn < error < fatal
		logger.trace("이것은 log4j의 Trace 레벨 메세지입니다.");
		logger.debug("이것은 log4j의 Debug 레벨 메세지입니다.");
		logger.info("이것은 log4j의 Info 레벨 메세지입니다.");
		logger.warn("이것은 log4j의 Warn 레벨 메세지입니다.");
		logger.error("이것은 log4j의 Error 레벨 메세지입니다.");
		logger.fatal("이것은 log4j의 Fatal 레벨 메세지입니다.");
//		properties 내용에 따라 log4j.rootLogger=debug, stdout, logfile > debug레벨부터 stdout콘솔창과 logfile파일에 출력
//		출력 형식)
//		log4j.appender.stdout.layout.ConversionPattern=%5p (%C{2}:%L) - %m%n
//		(5글자)
//		 INFO (basic.Log4jTest:17) - 이것은 log4j의 Info 레벨 메세지입니다.
//		 WARN (basic.Log4jTest:18) - 이것은 log4j의 Warn 레벨 메세지입니다.
//		ERROR (basic.Log4jTest:19) - 이것은 log4j의 Error 레벨 메세지입니다.
//		FATAL (basic.Log4jTest:20) - 이것은 log4j의 Fatal 레벨 메세지입니다.
		
		
//		형식2) logger객체변수.log(Level.로그레벨, "출력할 메시지")
		logger.log(Level.TRACE, "이것은 log4j의 Trace 레벨 메세지입니다.");
		logger.log(Level.DEBUG, "이것은 log4j의 Debug 레벨 메세지입니다.");
		logger.log(Level.INFO, "이것은 log4j의 Info 레벨 메세지입니다.");
		logger.log(Level.WARN, "이것은 log4j의 Warn 레벨 메세지입니다.");
		logger.log(Level.ERROR, "이것은 log4j의 Error 레벨 메세지입니다.");
		logger.log(Level.FATAL, "이것은 log4j의 Fatal 레벨 메세지입니다.");
		
		
		
	}

}
