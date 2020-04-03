namespace java com.henryxi.thrift.addserver

typedef i32 int

service AdditionService {
    int add(1:int n1, 2:int n2)
}

struct Pet {
    1: int age;
    2: string name;
}
