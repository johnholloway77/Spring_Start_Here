package ca.johnholloway.aspect;

import ca.johnholloway.model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect //annotation is not a sterotype. Will not create an instance in Spring context
@Order(1)
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Around("execution(* ca.johnholloway.service.*.*(..))")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
//
//        String methodName = joinPoint.getSignature().getName();
//        Object[] arguments = joinPoint.getArgs();
//
//        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute.\n");
//
//        Comment comment = new Comment();
//        comment.setText("some other text");
//        Object[] newArguments = {comment};
//
//        //If proceed is not called, then the aspect will not deligated to the method that it has interrupted.
//        Object returnedByMethod = joinPoint.proceed(newArguments); // new values can be passed to the interrupted method as an argument in proceed()
//        logger.info("Method call has completed and returned " + returnedByMethod);
//
//        return  "Failed";
//    }


//    @AfterReturning(value = "@annotation(ca.johnholloway.annotation.ToLog)", returning = "returnedValue") //"returnedValue" will not be resolved unless called in the subsequent method
//    public void log(Object returnedValue){
//        logger.info("\n\tMethod executed and returned  " + returnedValue);
//    }

    @Around("@annotation(ca.johnholloway.annotation.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        logger.info("\n\tLogging Aspect: Calling the method: " + methodName); //note to self: despite it saying that it is calling deleteComment() in the console
                                                                                    // the next item in the aspect chain is SecurityAspect

        Object returnedValue = joinPoint.proceed(); //Proceed executes further down the chain, which could be another aspect or intercepted method call

        logger.info("Logging Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
    }


}
