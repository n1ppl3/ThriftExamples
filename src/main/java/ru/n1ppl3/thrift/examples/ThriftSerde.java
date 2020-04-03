package ru.n1ppl3.thrift.examples;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TSerializer;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;


public abstract class ThriftSerde {

    private static TSerializer tSerializer = new TSerializer();
    private static TDeserializer tDeserializer = new TDeserializer();

    /**
     * thriftObject to bytes
     */
    public static byte[] serialize(TBase<?, ?> thriftObject) throws TException {
        return tSerializer.serialize(thriftObject);
    }

    /**
     * bytes to thriftObject
     */
    public static <F extends TFieldIdEnum, E extends TBase<?,F>> E deserialize(byte[] bytes, Class<E> _class) throws TException {
        try {
            Constructor<E> constructor = ReflectionUtils.accessibleConstructor(_class);
            E instance = constructor.newInstance();
            tDeserializer.deserialize(instance, bytes);
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new TException("error instantiating " + _class, e);
        }
    }
}
