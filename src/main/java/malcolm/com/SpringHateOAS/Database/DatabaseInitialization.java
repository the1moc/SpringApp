package malcolm.com.SpringHateOAS.Database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitialization implements CommandLineRunner{
	
	@Override
	public void run(String... strings) throws Exception {
		System.out.println("hello");
	}
}
