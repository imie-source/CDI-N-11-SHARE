package fr.imie.transactionalFramework;

import java.lang.reflect.Proxy;

public class TransactionalFactory<T extends ITransactional> {
	
	private static TransactionalFactory<?> instance;
	
    public synchronized static <T extends ITransactional> TransactionalFactory<?> getInstance() {
    	if (instance==null){
			instance = new TransactionalFactory<T>();
		}
    	return instance;
    }
	
	
	private TransactionalFactory(){
	}
	
	public T createTransactionalService(T service) {
		return createTransactionalService(service,null);
	}


	public T createTransactionalService(T service,ITransactional caller) {
			TransactionInvocationHandler invocationHandlerTransaction = new TransactionInvocationHandler(service);
			//invocationHandlerTransaction.setConnection(connectionInput);
			//invocationHandlerTransaction.setCaller(caller);
			return (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass()
					.getInterfaces(),invocationHandlerTransaction);
	
		}
	

}
