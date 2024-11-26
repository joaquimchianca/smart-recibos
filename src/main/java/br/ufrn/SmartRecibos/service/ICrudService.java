package br.ufrn.SmartRecibos.service;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T, ID> {

    public List<T> getAll();

    public Optional<T> find(ID id);

    public List<T> find(List<ID> ids);

    public T save(T entityT);

    public T update(T entityT, ID id);

    public void delete(ID id);
}
