package com.snacks.interfaces;
import com.snacks.model.responsables;
import java.util.*;

public interface crudResponsables {
    
    List getAll();

    responsables getById(Integer id);

    String add(responsables responsables);

    String updateById(responsables responsables);

    String deleteById(Integer id);
}
