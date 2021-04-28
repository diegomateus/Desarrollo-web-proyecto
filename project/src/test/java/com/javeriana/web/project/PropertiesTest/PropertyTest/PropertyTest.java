package com.javeriana.web.project.PropertiesTest.PropertyTest;

import com.javeriana.web.project.Properties.Property.Aplication.Create.PropertyCreator;
import com.javeriana.web.project.Properties.Property.Aplication.Find.PropertyFinder;
import com.javeriana.web.project.Properties.Property.Aplication.Update.PropertyModifier;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PropertyTest {

    @Test
    void should_create_property(){
        PropertyRepository repository = mock(PropertyRepository.class);
        PropertyCreator creator = new PropertyCreator(repository);
        Property actualProperty = new Property("1","calle 100","arriendo","bogota","es grande","3","2","1000","100","3","nueva","8 de mayo","chapinero","3","hola");
        creator.execute("1","calle 100","arriendo","bogota","es grande","3","2","1000","100","3","nueva","8 de mayo","chapinero","3","hola");
        verify(repository,atLeastOnce()).save(actualProperty);
    }

    @Test
    void should_find_property(){
        PropertyRepository repository = mock(PropertyRepository.class);
        Property actualProperty = new Property("1","calle 100","arriendo","bogota","es grande","3","2","1000","100","3","nueva","8 de mayo","chapinero","3","hola");
        Mockito.when(repository.find("1")).thenReturn(Optional.of(actualProperty));
        PropertyFinder finder = new PropertyFinder(repository);
        assertEquals(actualProperty,finder.execute("1"));
    }

    @Test
    void should_update_property(){
        PropertyRepository repository = mock(PropertyRepository.class);
        Property actualProperty = new Property("1","calle 100","arriendo","bogota","es grande","3","2","1000","100","3","nueva","8 de mayo","chapinero","3","hola");
        Property propertyEdited = new Property("1","calle 105","venta","bogota","es grande","3","2","1000","100","3","nueva","8 de mayo","chapinero","3","hola");
        Mockito.when(repository.find("1")).thenReturn((Optional.of(actualProperty)));
        PropertyModifier modifier = new PropertyModifier(repository);
        modifier.execute("1", "calle 105","venta","bogota","es grande","3","2","1000","100","3","nueva","8 de mayo","chapinero","3","hola");
        verify(repository,atLeastOnce()).update("1", propertyEdited);
    }
}
