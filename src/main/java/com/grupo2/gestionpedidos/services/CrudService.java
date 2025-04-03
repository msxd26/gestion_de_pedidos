package com.grupo2.gestionpedidos.services;

public interface CrudService<RS, RQ, ID> {

    RS findById(ID id);

    RS save(RQ rq);

    RS update(RQ rq, ID id);

    void delete(ID id);
}
