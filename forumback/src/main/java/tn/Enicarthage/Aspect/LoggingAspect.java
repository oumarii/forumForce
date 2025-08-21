package tn.Enicarthage.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

	Logger log = (Logger) LoggerFactory.getLogger(LoggingAspect.class);
			@Before("execution(* tn.Enicarthage.SERVICES.*.*(..))")
			public void logMethodEntry(JoinPoint joinPoint) {
			String name = joinPoint.getSignature().getName();
			String className = joinPoint.getTarget().getClass().getSimpleName();
			log.info("la methode Execute est:  " + name + " de la class:   "+className);
			}
   
}     