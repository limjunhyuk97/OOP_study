# Object-Oriented Analysis and Design

## Object-Oriendted Analysis (무엇을)
  - 주어진 문제의 주요한 과제들을 파악한다. (문제점 파악 - 속성들 파악)
  - 문제에 내재된 성질들을 객체 지향적으로 파악한다.
## Object-Oriented Design (어떻게)
  - 주어진 문제에 대한 Software적인 해결방법을 찾는다. (코드 구현 단계 - 행동들 파악)
  - 문제를 객체 지향적인 방법으로 해결하는 방법을 찾는다.

## OOAD steps
  - class 식별
  - 속성 식별
  - 행동 식별
  - 알고리즘 디자인
  - 네 가지의 단계는 서로 유기적이다.

### 1. identifying class
  - 객체지향은 행동중심적인 평등한 객체들의 공동체를 구현하는 것이다!
  - 물질적인 개념, 추상적인 개념에서 **행동들을 바탕으로 객체를 찾는다.**
  - 객체들간의 **관계에 주목**한다. 즉, 객체들의 **행동에 주목**한다.
  - 이러한 관계들을 UML class diagram으로 표현한다.

![class diagram](https://user-images.githubusercontent.com/59442344/113262729-e4f33700-930b-11eb-8237-d8cf4a985290.png)

### 2. Identifying Attributes
  - 속성 정보를 찾는다. 즉, **상태 정보**를 찾는다. (primitive type, reference type, class type, ,,)
  - **행동과 관계(역할), 책임**을 바탕으로 발견한 **객체들에게 필요한 속성을 부여**한다.
  - 상태 정보를 UML class diagram 내부에 추가한다.

![class diagram2](https://user-images.githubusercontent.com/59442344/113262730-e58bcd80-930b-11eb-91d5-88bf114b86d6.png)

### 3. Identifying Methods
  - 시작 class (main method가 위치한 class)가 담당해야할 task를 위한 work flow를 파악한다.
  - **work-flow의 sub-task 세분화**
    - 각 **sub-task들이 곧 행동**이다.
    - sub-task들은 객체 간의 메시지의 전달이다. ( **상태 정보 = 대상객체.객체가취해줄행동(인자전달)** )
    - **work-flow <- sub-task : 행동 : 객체간 상호작용**
  - **assiging responsibility**
    - task들을 객체들에게 할당한다.
    - **task에 대한 정보를 많이 갖고 있는 객체에게 method(task)를 할당한다!** 
  - Work flow의 task를 판별하지 않더라도 일반적으로 전체 또는 일부 method 식별 가능한 경우 존재.
    - Stack 
    - Queue
    - Account
    - Java Collection Framework (일반화된 자료구조 클래스에 대한 라이브러리 제공)

## Implementation
  - 클래스 구현할 때, 가장 의존도가 낮은 class 부터 구현한다.
  - field가 너무 많은 경우에는 Address로 묶어서 표현할 수 있을 것이다.
  - 모든 field에, 대응하는 accessor와, mutator method가 필요하지 않다.
  - class에 너무 많은 책임을 한번에 담지 말자!
  - class와 method 이름은 갖고있는 책임에 대해서 잘 담고 있어야 한다.
  - 되도록이면 immutable class를 지향하자!
