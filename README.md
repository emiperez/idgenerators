# idgenerators
Id Generators for Java.

Some classes that implement the interface IdGenerator<T> where T is the type returned by its only method getId():

Class | Description
------------ | -------------
ConstantIdGenerator<T> | This IdGenerator always returns the same id, which is defined on the constructor.
DateTimeIdGenerator | This IdGenerator returns a String built by the Date and Time and, if there already was another id at the same time, a sequential number appended.
SequentialIdGenerator | A thread safe IdGenerator based on AtomicInteger.
UuidIdGenerator | An IdGenerator based on UUID.randomUUID().
