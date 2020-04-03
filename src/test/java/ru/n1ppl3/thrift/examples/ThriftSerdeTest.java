package ru.n1ppl3.thrift.examples;

import com.henryxi.thrift.addserver.Pet;
import org.apache.thrift.TException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ThriftSerdeTest {

    @Test
    void serdeTest() throws TException {
        Pet myPet = new Pet(1, "kitty");
        System.out.println("myPet: " + myPet);

        byte[] serialized = ThriftSerde.serialize(myPet);
        System.out.println("serialized: " + Arrays.toString(serialized));

        Pet restored = ThriftSerde.deserialize(serialized, Pet.class);
        System.out.println("restored: " + restored);
        assertEquals(myPet, restored);
    }

}
