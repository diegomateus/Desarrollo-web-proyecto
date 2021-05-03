package com.javeriana.web.project.Properties.Property.Infrastructure.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Image;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImagesCustomDetail implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x,y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<Image> response=null;
        try {
            Optional<String> value= Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()){
                List<HashMap<String,Object>> objecs=new ObjectMapper().readValue(value.get(),List.class);
                response=objecs.stream().map(image ->
                        new Image((String) image.get("id"),
                        (String) image.get("image"))).collect(Collectors.toList());
            }
        }catch (Exception e){
            throw new HibernateException("Error at reading map",e);
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<Image>> images=(value == null) ? Optional.empty() : (Optional<List<Image>>) value;
        try {
            if(images.isEmpty()){
                st.setNull(index,Types.VARCHAR);
            }else{
                ObjectMapper mapper = new ObjectMapper();
                List<HashMap<String,Object>> objects= images.get().stream().map(image->image.data()).collect(Collectors.toList());
                String serializedList= mapper.writeValueAsString(objects).replace("\\","");
                st.setString(index,serializedList);
            }

        }catch (Exception e){
            throw new HibernateException("Exception serializable value  "+value,e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
