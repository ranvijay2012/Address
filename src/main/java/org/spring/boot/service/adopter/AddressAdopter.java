package org.spring.boot.service.adopter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressAdopter<S, T> {

    @Autowired
    private ModelMapper modelMapper;


    public List<T> mapOneTypeListToAnotherType(List<S> srcList, Class<T> trgClass) {
        List<T> trgList = srcList.stream().map(srcObj -> modelMapper.map(srcObj, trgClass)).toList();
        return trgList;
    }

    public T mapOneObjectToAnother(S srcObj, Class<T> trgClass) {
        T trgObj = modelMapper.map(srcObj, trgClass);
        return trgObj;
    }
}
