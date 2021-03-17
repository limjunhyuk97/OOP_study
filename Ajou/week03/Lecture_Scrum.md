# Object And Classes

## Structured programming vs Object Oriented programming
  - **Structured programming** : determine procedure -> store data, more appropriate for smaller jobs
  - **OOP** : store data -> determine procedure, high reusibility, more appropriate for larger jobs

## Feature of OOP
  - OOP is **made of objects** which **has a special functionality, exposed to its users, and a hidden implementation(Encapsulation)**
  - object is **custom-designed(user defined)** or **taken "off-the-shelf"(library)**
  - **Encapsulation (hiding)**
    - **combining data and behavior** : data + behavior
    - **Hiding implementation details** : 안으로 숨겨야할 사항들을 정한다. (user가 직접 이용하는데 필요한 부분들)
    - **exposing external behavior (public methods)** : 겉으로 드러내야할 사항들을 정한다. (user가 이용하는데 몰라도 되는 부분들, data 엮임 방지)
    - **method never directly access instance fields in a class other than their own** : 자기 필드 빼고는 함부로 접근 불가능.
    - **key of reuse and reliability**
    - Class are the unit of encapsulation
    - 언어적 구현의 관점 : 재사용성을 높인다. 사용자가 동작의 방식을 몰라도 쉽게 이용할 수 있게 된다.
  - **Inheritance (Reusing)**
    - Reusing existing classes
    - SuperClass - SubClass relationship
    - 재사용성을 높인다. 이전의 성질들에 추가된 성질들을 가미하여, 처음부터 다시 구현할 필요가 없게끔, 재사용이 용이해진다.
  - **Data abstraction**
    - 어떤 정보를 encapsulate 할 것인가? 
    - generalization
    - specification    
    - 성질의 관점

## Value chain of OOP
  - cost reduction by increasing productivity
  - increasing productivity by effective development and, maintenance
  - effective development and, maintenance by reusibility (easy to read and write)
  - increasing reusibility by encapsulation, Inheritance

## Class and Object
  - **Class** : template and blueprint
    - describes object data(field) and, behavior(method)
    - uses 'method' to send message between objects
  - **Object** : Instance made by the template(Class)
  - **Object's 3 key characteristic**
    - **behavior** : what can we do with objects
    - **state** : object's information about what it currently looks like == how does the object reacts == different state, same method, different outcome
    - **identity** : objects that are **instance of class are always differ in their identity**, **usually differ int their state**.

## Identifing Class and Methods
  - Responsibility assignment
    - identify responsibility -> identify methods and classes -> identify data(attributes)  

## Relationship between Classes
  - "use-a" : association : 사용관계 : 상호작용
  - "has-a" : aggregation and composition : 집합관계 : 부품
  - "is-a" : inheritance : 상속관계 : 구체화된 하위객체
  - UML (Unified Modeling Language) -> Object-Oriented Analysis and Design (Object-Oriented Development Methodology)
    - Class Diagram
    - Sequence Diagram
    - Activity Diagram (=~ flow chart) 
    - Use cas Diagram
