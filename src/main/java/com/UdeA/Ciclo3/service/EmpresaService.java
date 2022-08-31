package com.UdeA.Ciclo3.service;
import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.repo.EmpresaBikeHouseProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// Le decimos a Spring que esta clase es de servicios
@Service
public class EmpresaService {
    @Autowired  //Conectamos esta clase con el repository de empresa
    EmpresaBikeHouseProject empresaBikeHouseProject;  //Creamos un objeto tipo EmpresaRepository para poder usar los metodos de dicha clase

    //Metodo que retornara la lista de empresas usando metodods heredados del jpaRepository
    public List<Empresa> getAllEmpresa(){
        List<Empresa> empresaList= new ArrayList<>();
        empresaBikeHouseProject.findAll().forEach(empresa -> empresaList.add(empresa));  //Recorremos el iterable que regresa el metodo finAll del Jpa y lo guardamos en la lista
        return empresaList;
    }
    //Metodo que trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaBikeHouseProject.findById(id).get();

    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaBikeHouseProject.save(empresa);
        if (empresaBikeHouseProject.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    //Metodo para eliminar empresa registrada teniendo el id
    public boolean deleteEmpresa(Integer id){
        empresaBikeHouseProject.deleteById(id);  //Eliminar
        if (empresaBikeHouseProject.findById(id)==null){  //Verificacion del servicio eliminacion
            return true;
        }
        return false;
    }


}
