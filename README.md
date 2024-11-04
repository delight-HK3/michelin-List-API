# michelin List API

### API 구성
```
Framework : Spring boot 3.3.4
Language : Java 17
Database : MariaDB Server
Server : AWS EC2, AWS API Gateway
Tool : Visual Studio Code
Pakaging : jar 
```

```
AWS WAS & DB Server

AWS 리전 : ap-northeast-2 (서울)
AWS OS : Amazon Linux 2 Kernel 5.10 AMI 2.0.20241014.0 x86_64 HVM gp2
인스턴스 유형 : t2.micro
용량 : 8 GIB
볼륨 유형 : gb2
```
<br>

### API 소개
미쉐린 공식 가이드 사이트 및 네이버지도에 미쉐린 및 빕 구르망으로 검색하면 위치는 확인 할 수 있으나 미쉐린 가이드에 등재된 좌표
데이터는 없었습니다, 그리고 미쉐린 가이드나 네이버지도에서는 최신자료만 확인이 가능하기에 과거에 어떤 레스토랑이 미쉐린 스타를 받았는지는
따로 조사를 해야만 알 수 있습니다. 거기서 이렇게 API로 만들고 데이터를 관리하면 앞으로의 활용가치가 분명생길 것 이라고 판단하여 개발하게 되었습니다.
API요청방식은 [공공데이터](https://www.data.go.kr/)의 openAPI 호출방식과 유사하게 HTTP API방식으로 설계했습니다, 현재는 대한민국 데이터만 출력이 되지만
앞으로 일본 및 아시아권 데이터출력이 현재방향입니다.
<br><br>

### API 사용가이드
#### 요청 파라미터

| 파라미터명 | 설명 | 데이터타입 | 필수여부 | 기타 |
| ------ | ------ | ----- | ----- | ----- |
| row | 불러올 행 수 | Integer | O |
| fcltyNm | 레스토랑 이름 | String | X |
| starCnt | 별 개수 | Integer | X | 3 : 미쉐린 3스타 <br> 2 : 미쉐린 2스타 <br> 1 : 미쉐린 1스타 <br> 0 : 빕 구르망
| year | 시도영문명 | Integer | X | 입력하지 않은경우 현재년도의 데이터가 출력됩니다. |
| sustainAbility| 지속가능성| Integer | X | 1 : 지속가능성 존재 <br> 0 : 지속가능성 미존재 |
| ctprvnEngNm | 시도영문명 | String | X |

#### URL 분기
| URL 분기 | 설명 |
| ------ | ------ |
| /kr/michelin-list | 대한민국 미쉐린 데이터 출력 |
| /jp/michelin-list | 일본 미쉐린 데이터 출력 |

#### 출력결과
| 항목명 | 설명 |
| ------ | ------ |
| michelinNm | 미슐랭명 |
| rdnmadrNm | 레스토랑이름 |
| ctprvnEngNm | 시도영문명 |
| foodCatg | 식사카테고리 |
| fcltyLo | 위도 |
| fcltyLa | 경도 |
| starCnt | 별 개수 |
| year | 획득년도 |
| sustainability | 지속가능성 |

<br>

#### 사용예시
```
https://url.mlistapi.link/kr/michelin-list?row=100&starCnt=1
```
해석) 대한민국에서 미쉐린별을 1개만 받은 레스토랑을 100건 조회

<br>

### 참고자료
* 미쉐린 레스토랑 가이드(데이터 수집) : <https://guide.michelin.com/kr/ko> 
* AWS 구축 및 기본 세팅 : <https://velog.io/@osmdark/1.AWS%EC%84%9C%EB%B2%84-%EA%B5%AC%EC%B6%95%ED%95%98%EA%B8%B0>
* AWS 기본적인 개념 및 설명 : <https://velog.io/@server30sopt/AWS-EC2-%EA%B0%9C%EB%85%90-%EC%A0%95%EB%A6%AC>
* AWS API Gateway 사용법 : <https://fransoaardi.github.io/posts/aws_api_gateway_rest_http/>

<br>

### 패치노트
---

#### v.1.4 (2024.11.04)
1. 일본 미쉐린 테이블에 1스타 정보를 추가 했습니다.
2. 2025년도가 되어도 2024년 데이터가 확인가능하도록 수정 했습니다.
3. 지속가능성 여부를 확인이 가능하도록 호출파라미터에 추가 했습니다.
<br>

---
#### v.1.3 (2024.10.29)
1. 일본 미쉐린 테이블에 2스타 정보를 추가했습니다.
2. 기존에 API Gateway에서 지급한 기본 도메인에서 사설도메인으로 변경했습니다.
3. 하단 테이블에 있는 레스토랑의 좌표정보가 변경되었습니다.

| 레스토랑 이름 | 국가 | 등급 |
| --- | --- | --- |
| 스시 마츠모토 | 대한민국 | 미쉐린 1스타 |
| 명동 교자 | 대한민국 | 빕 구르망 |
| 현우동 | 대한민국 | 빕 구르망 |
| 역전회관 | 대한민국 | 빕 구르망 |
| 유림면 | 대한민국 | 빕 구르망 |
| 베이스 이즈 나이스 | 대한민국 | 빕 구르망 |

<br>

---
#### v.1.2 (2024.10.27)
1. 데이터베이스 서버를 추가로 구축하여 새로 구축한 서버를 바라보도록 수정
2. 결과데이터에 '지속가능성'을 추가
<br>

---
#### v.1.1 (2024.10.21)
1. 국가별 호출을 파라미터 변수에서 url에 삽입하여 구분을 짓는 방식으로 변경했습니다.
2. API호출시 데이터조회 부분코드를 수정했습니다.
3. 일본 미쉐린 데이터 DDL 쿼리문을 추가헸습니다.
<br>

---
#### v.1.0 (2024.10.19)
1. 일본 미쉐린 데이터도 확인이 가능하도록 테이블을 추가했습니다.

