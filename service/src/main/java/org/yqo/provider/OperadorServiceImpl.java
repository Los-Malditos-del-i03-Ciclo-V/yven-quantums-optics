package org.yqo.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yqo.contract.ICrudService;
import org.yqo.model.operador.entity.OperadorEntity;
import org.yqo.persistence.entity.operador.OperadorRepository;

import java.util.List;

@Service
public class OperadorServiceImpl implements ICrudService<OperadorEntity, Integer> {

    @Autowired
    private OperadorRepository operadorRepository;


    @Override
    public OperadorEntity createEntity(OperadorEntity entity) {
        return operadorRepository.save(entity);
    }

    @Override
    public OperadorEntity findEntityById(Integer id) {
        return operadorRepository.findById(id).get();
    }

    @Override
    public List<OperadorEntity> findAllEntities() {
        return operadorRepository.findAll();
    }

    @Override
    public OperadorEntity updateEntity(OperadorEntity entity) {
        return null;
    }

    @Override
    public void deleteEntityById(Integer id) {
        operadorRepository.deleteById(id);
    }
}