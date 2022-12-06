package org.jhotdraw.samples.util;
/**
 * author: Stped18
 * email: stped18@student.sdu.dk
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import java.io.IOException;
import java.util.logging.FileHandler;


@Aspect
public class RuntimeLogger {
  private FileHandler fileHandler;

  private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Feature Logger");



  private RuntimeLogger() throws IOException {
    fileHandler=new FileHandler("Feature_Logger.log", true);
    fileHandler.flush();
    logger.addHandler(fileHandler);

  }



  @Around("execution(* *(..)) && @annotation(Tracker)")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    Object result = point.proceed();
    logger.info( "\u001B[32m method : "+ MethodSignature.class.cast(point.getSignature()).getMethod().getName()+" Arguments : "+ point.getArgs()+" result : "+ result);
    return result;
  }



}