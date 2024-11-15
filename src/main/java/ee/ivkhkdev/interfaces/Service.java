package ee.ivkhkdev.interfaces;

import java.util.List;

public interface Service<T> {
    boolean add();
    boolean edit();
    boolean remove(T entity);
    boolean print();
    List<T> list();

}
