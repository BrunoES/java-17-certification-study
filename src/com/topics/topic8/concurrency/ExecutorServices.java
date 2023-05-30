package com.topics.topic8.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * https://www.baeldung.com/java-executor-service-tutorial
 * https://www.digitalocean.com/community/tutorials/java-lock-example-reentrantlock
 */
public class ExecutorServices {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		overview();
		futures();
		scheduledExecutorService(); 
	}
	
	public static void overview() {
		System.out.println("\n overview");
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		// CRIANDO THREADS:
		Runnable runnableTask = () -> {
		    try {
		        TimeUnit.MILLISECONDS.sleep(300);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Callable<String> callableTask0 = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution 0";
		};
		
		Callable<String> callableTask1 = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution 1";
		};
		
		Callable<String> callableTask2 = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution 2";
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask0);
		callableTasks.add(callableTask1);
		callableTasks.add(callableTask2);
		
		// PROCESSANDO THREADS:
		
		// Runnable não tem retorno, usa-se execute
		executor.execute(runnableTask);
		
		// Callable tem retorno, usa-se submt
		Future<String> f0 = executor.submit(callableTask0);
		
		
		try {
			// Retorna String
			String result = executor.invokeAny(callableTasks);
			System.out.println(result);
			
			// Retornar Futures
			List<Future<String>> futures = executor.invokeAll(callableTasks);
			futures.forEach((f) -> {
				if(f.isDone()) {
					try {
						String a = f.get();
						System.out.println(a);
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		// PARANDO EXECUTOR SERVICE:
		
		// Encerra executar service quando todas as tasks são completadas.
		executor.shutdown();
		// Tenta encerrar o executar service imediatamente e retorna todas as tasks que aguardavam processamente.
		List<Runnable> notExecutedTasks = executor.shutdownNow();
		
		
		// Boa prática recomendada pela Oracle para encerrar o ExecutorService:
		executor.shutdown();
		try {
		    if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
		    	executor.shutdownNow();
		    } 
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
	}
	
	public static void futures() {
		System.out.println("\n futures");
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		Callable<String> callableTask0 = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution 0";
		};
		
		Future<String> f0 = executor.submit(callableTask0);
		
		// f0.cancel(false); Se cancelar o Future antes de dar get, ocorrerá um CancellationException
		try {
			var s0 = f0.get(); // Obtem valor se feature já foi completado
			var s1 = f0.get(2000, TimeUnit.MILLISECONDS); // Obtem valor mediante timeout
			
			System.out.println(s0);
			System.out.println(s1);
			
			// Outros metodos:
			f0.isCancelled();
			f0.isDone();
			f0.cancel(false);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	public static void scheduledExecutorService() throws InterruptedException, ExecutionException, TimeoutException {
		System.out.println("\n scheduledExecutorService");
		
		// CRIANDO THREADS:
		Runnable runnableTask = () -> {
		    try {
		        TimeUnit.MILLISECONDS.sleep(300);
		        System.out.println("Executando Runnable");
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Callable<String> callableTask = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution 0";
		};
		
		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		
		// AGENDAMENTO COMUM:
		// Agendamento de Runnable, não tem retorno
		scheduledExecutor.schedule(runnableTask, 1, TimeUnit.HOURS);
		
		// Agendamento de Callable, tem retorno Future
		Future<String> f0 = scheduledExecutor.schedule(callableTask, 2, TimeUnit.SECONDS);
		// Se não executar thread a tempo, causará timeout, pois ainda não executou Callable;
		System.out.println(f0.get(3000, TimeUnit.MILLISECONDS)); 
		
		// AGENDAMENTO RECORRENTE:
		// Demora 2 seg para começar, e depois executa a cada 500 milliseconds.
		scheduledExecutor.scheduleAtFixedRate(runnableTask, 2000, 500, TimeUnit.MILLISECONDS);
		
		// Demora 2 seg para começar, e depois começa a executar as threds, quando uma terminar, aguardará 500 milliseconds para começar a próxima;
		scheduledExecutor.scheduleWithFixedDelay(runnableTask, 2000, 500, TimeUnit.MILLISECONDS);
	}
	
}
