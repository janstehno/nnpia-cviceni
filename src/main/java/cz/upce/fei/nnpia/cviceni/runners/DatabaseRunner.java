package cz.upce.fei.nnpia.cviceni.runners;

import cz.upce.fei.nnpia.cviceni.entities.AppUser;
import cz.upce.fei.nnpia.cviceni.repository.AppUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner {

    private final AppUserRepository appUserRepository;

    public DatabaseRunner(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AppUser user = new AppUser();
        user.setUsername("Jan");
        user.setPassword("jan");
        user.setActive(true);
        appUserRepository.save(user);
    }
}
