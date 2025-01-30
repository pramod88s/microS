package com.bvr.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedDbPatterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SharedDbPatterApplication.class, args);
	}

	private static final Logger Log = LoggerFactory.getLogger(SharedDbPatterApplication.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Log.info("DB Application has started");

		bookRepository.save(new Book("Javascript"));
		bookRepository.save(new Book("Python"));
		bookRepository.save(new Book("PySpark"));
		bookRepository.save(new Book("PyTorch"));
		bookRepository.save(new Book("Java"));
		bookRepository.save(new Book("Erlang"));
		bookRepository.save(new Book("Scala"));
		bookRepository.save(new Book("Golang"));

		Log.info("Find all records...");
		bookRepository.findAll().forEach(r -> System.out.println(r));

		Log.info("Find by id...");
		bookRepository.findById(8L).ifPresent(r -> System.out.println(r));

		Log.info("Find by name...");
		bookRepository.findByName("Python").forEach(r -> System.out.println(r));

		/*
		 * Log.info("Delete by Book Id..."); Book bookToDelete =
		 * bookRepository.findById(53L).get(); System.out.println("Book to delete: " +
		 * bookToDelete.getName()); bookRepository.delete(bookToDelete);
		 */

		/*
		 * Log.info("Delete by Book Title...");
		 * bookRepository.findByName("PyTorch").forEach(book -> {
		 * System.out.println("Deleting Book: " + book.getName());
		 * bookRepository.delete(book);
		 * 
		 * });
		 */

		/*
		 * Log.info("Delete by Book Id..."); bookRepository.deleteById(57L);
		 */

		/*
		 * Log.info("Delete All by Book Id...");
		 * bookRepository.deleteAllById(Arrays.asList(54L, 58L, 59L));
		 */

		/*
		 * Log.info("Delete All by Book Name...");
		 * bookRepository.deleteAll(bookRepository.findByName("PySpark"));
		 */
		
		
		Log.info("Updating records...");
		bookRepository.findById(108L).ifPresent(book -> {
			System.out.println("Updating record with Id: 108");
			book.setName("Scala - Spark");
			bookRepository.save(book);

		});

	}

}
