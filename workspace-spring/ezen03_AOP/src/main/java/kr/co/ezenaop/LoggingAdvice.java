package kr.co.ezenaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//어드바이스 클래스
public class LoggingAdvice implements MethodInterceptor {

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			// TODO Auto-generated method stub
			
			System.out.println("타겟 메세지 호출 전: LoggingAdivice");
			System.out.println(invocation.getMethod()+"메서드 호출 전");
			
			//타겟 메서드를 호출
			invocation.proceed();
			
			System.out.println("타겟 메세지 호출 후: LoggingAdivice");
			System.out.println(invocation.getMethod()+"메서드 호출 후");
			return null;
		}
}