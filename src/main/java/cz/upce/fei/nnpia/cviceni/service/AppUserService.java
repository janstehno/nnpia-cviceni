package cz.upce.fei.nnpia.cviceni.service;

import cz.upce.fei.nnpia.cviceni.entities.AppUser;
import cz.upce.fei.nnpia.cviceni.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements ServiceI<AppUser> {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<AppUser> getAllObjects() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getObjectById(Long id) {
        Optional<AppUser> appUser = appUserRepository.findById(id);
        return appUser.orElse(null);
    }

    @Override
    public AppUser createObject(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser updateObject(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public void deleteObject(Long id) {
        appUserRepository.deleteById(id);
    }
}
