package com.javeriana.web.project.PropertiesTest.PropertyTest;

import com.javeriana.web.project.Properties.Property.Aplication.Create.PropertyCreator;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
