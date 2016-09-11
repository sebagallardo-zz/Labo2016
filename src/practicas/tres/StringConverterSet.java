package practicas.tres;


import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class StringConverterSet extends AbstractSet {


    class IteratorStringAdapter implements Iterator{

        private Object[] items = toArray();
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < items.length ;
        }

        @Override
        public Object next() {
            return items[pos++].toString();
        }
    }

    @Override
    public Iterator iterator() {
        return new IteratorStringAdapter();
    }

    @Override
    public int size() {
        return 0;
    }
}
