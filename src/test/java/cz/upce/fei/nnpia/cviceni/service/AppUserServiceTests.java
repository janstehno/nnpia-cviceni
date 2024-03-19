package cz.upce.fei.nnpia.cviceni.service;

import cz.upce.fei.nnpia.cviceni.entities.AppUser;
import cz.upce.fei.nnpia.cviceni.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AppUserServiceTests {

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private AppUserService appUserService;

    @BeforeEach
    void setUp() {
        AppUser user = new AppUser(100L, "testUser", "testPassword", true, null, null, null, null);
        when(appUserRepository.findById(100L)).thenReturn(Optional.of(user));
    }

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
    }

    /*
     * Pokud se má testovat chybový stav a očekává se, že vyvolá výjimku, můžeme použít anotaci
     * @Test s parametrem expected a udat typ očekávané výjimky.
     * @Test(expected = SomeException.class)
     */
    @Test
    void testFindById() {
        AppUser user = appUserService.getObjectById(100L);
        assertEquals(100L, user.getId());
        assertEquals("testUser", user.getUsername());
    }
}

