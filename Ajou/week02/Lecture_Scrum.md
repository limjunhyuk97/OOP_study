## Unicode와 Java character 표현의 관계
  - **Unicode란?**
    - Unicode는 다양한 언어의 존재로 인해서 기존의 encoding scheme으로는 그 많은 언어들을 encoding하기 어렵기에 등장한 encoding scheme이다.
    - UTF(Unicode Transformation Format)-32, UTF-16 , UTF-8의 방법이 있다.
    - Java에서는 character 표현을 위해서 UTF-16의 방식을 채택하고 있다.
  - **UTF-16 방식은 무엇인가?**
    - UTF-16 방식은 Unicode encoding scheme의 하나로, 문자를 표현하는데 많게는 2code unit을 사용한다.
      - code unit이란, 16비트 크기의 한 단위이다.
      - 자세히 말하면, BMP(Basic multilingual plane: 기존 문자들)을 표현하는데는 1code unit을 사용한다.
      - Supplementary plane(추가된 문자들)을 표현하는데는 2code unit을 사용하는데, BMP를 표현하고 남은 surrogate area + 1code unit을 사용하는 방식을 이용한다.
  - **Java에서는 어떻게 적용되는가?**
    - Java는 UTF-16방식을 채택했지만, 문자를 표현하는데는 문자 한개당 16비트(1code unit)를 할당해준다.
    - 그렇기에 2code unit을 사용하는 경우(Supplementary plane의 경우)에는, 2개의 문자공간을 사용해야 한다.
    - 이런 복잡한 과정때문에, 왠만하면 String class의 이용을 권장하는 편이다.

## Java 언어에서 primitive type을 function parameter로 전달하는 방법과, reference type을 function parameter로 전달하는 방법의 차이가 무엇인가??
  - **Java에서는 함수로 인자 전달 시에, 항상 call-by-value의 방법으로 전달된다.**
  - **primitive type을 함수에 전달하는 경우**
    - call-by-value의 방식이기에, 값이 복사된다.
    - 그렇기에 함수 밖의 값의 변화는 일어나기 어렵다. 
  - **reference type을 함수에 전달하는 경우**
    - call-by-value 방식으로, heap 영역에 존재하는 실체의 주소 값이 전달된다.
    - 주소값이 가리키는 곳에 있는 실체의 값을 변경시키기에 함수 밖에서의 변화가 일어날 수 있다.
      - immutable 객체의 전달에서는 함수 밖에서의 변화가 일어나지 않을 수 있다.
      - 복사에서의 문제 : 얕은 복사의 경우, 복사된 값과 원본의 값의 주소가 엮여서 문제가 발생할 수 있다.
