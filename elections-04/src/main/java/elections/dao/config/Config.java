package elections.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import elections.dao.service.IElectionsDao;
import elections.dao.service.ElectionsDaoFile;

@Configuration
@ComponentScan({ "elections.dao.entities" })
public class Config {
	
	// implémentation 1
	@Bean
	public IElectionsDao electionsDaoFile() {
		
		return new ElectionsDaoFile("elections-in-good.txt","elections-out.txt","elections-log.txt");
	}
}