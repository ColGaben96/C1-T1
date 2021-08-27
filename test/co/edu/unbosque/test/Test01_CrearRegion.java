package co.edu.unbosque.test;

import co.edu.unbosque.model.RegionDAO;
import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;


public class Test01_CrearRegion {
    private RegionDAO region = new RegionDAO();
    @BeforeEach
    public void setup() throws AlreadyExistsException, IOException {
        region.save(0, "Narnia");
    }
    @Test
    public void crearUnaRegion() throws AlreadyExistsException, IOException, NotFoundException {
        region.save(1, "Delta Amarcuro");
        Assertions.assertEquals("Delta Amarcuro", region.findByID(1).getNombre());
        region.delete(region.findByID(1));
    }
    @Test
    public void crearUnaRegionRepetida() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            region.save(0, "Narnia");
        });
    }
    @AfterEach
    public void eliminar() {
        Assertions.assertDoesNotThrow(() -> {
         region.delete(region.findByID(0));
        });
    }
}
