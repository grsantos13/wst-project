package br.com.rssistemas.wst.operation.validations.validator;

import br.com.rssistemas.wst.operation.validations.annotation.Unique;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {
    private String field;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(Unique params) {
        this.field = params.field();
        this.aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Assert.state(manager != null, "O EntityManager está nulo. Verificar se a anotação foi colocada dentro do contexto do Spring.");

        Query query = manager.createQuery("select 1 from " + aClass.getName() + " where " + field + " = :value");
        query.setParameter("value", value);
        List<?> resultList = query.getResultList();

        Assert.state(resultList.size() <= 1, "Foi encontrado mais de um " + aClass.getSimpleName() + " com o atributo " + field + " com valor " + value);

        return resultList.isEmpty();
    }
}
