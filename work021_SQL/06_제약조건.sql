-- 제약 조건
-- EMPLOYEE | DEPARTMENT 2개를 생성
-- CTAS

DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE EMPLOYEE
AS
(SELECT * FROM EMP);


CREATE TABLE DEPARTMENT
AS
(SELECT * FROM DEPT);

-- 테이블 구조 확인
DESC EMPLOYEE;
DESC DEPARTMENT;
-- CTAS로 끌어당겨 온 것은, NOT NULL 확인은 불가함. (제약조건 안딸려옴)
-- PK(기본키) 제약조건을 테이블에 추가.
-- EMPLOYEE, DEPARTMENT 테이블에 기본키 제약조건을 추가함.
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);


DELETE EMPLOYEE WHERE EMPNO=7369;
SELECT * FROM EMPLOYEE;

-- 20번 부서를 삭제하더라도, 20번 부서에서 근무하는 직원은 그대로이다.
-- 이것은, EMPLOYEE 테이블과 DEPARTMENT 테이블이 연관,(RELATIONAL) 되어있지 않기 때문임.
-- FK 제약조건을 추가해야함.
DELETE DEPARTMENT WHERE DEPTNO =20;
SELECT * FROM DEPARTMENT;

-------------------------------------------
-- 3. 외래키 제약조건 추가하기. (이렇게 주는것은 x)
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno);

-- FK가 지정되어 있는 테이블이 자식이라고 보면 된다. 갖다 쓰는게 없는게 의존성이 없는 것이고 부모인 것.


DELETE EMPLOYEE WHERE EMPNO=7369;
SELECT * FROM EMPLOYEE;

DELETE DEPARTMENT WHERE DEPTNO =20;
SELECT * FROM DEPARTMENT;

-- ORA-02292: 무결성 제약조건(MYKB.EMPLOYEE_DEPTNO_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
-- PK를 뒀을 때, = 기본키만 줬을 떄에는, EMPLOYEE와 DEPT-- 가 아무 연관이 없기에, 20 부서 없애려면 양쪽을 모두 지워야함.
-- FK를 두면 부모 테이블을 죽일 수 없음. 자식 값들을 다 죽이면 죽여짐. 이것도 안하려면, FK 제약조건 줄 때 CASCADE 옵션을 주면됨.

-- 요약
-- FK 제약 조건을 추가하면, 자식이 있는 부모테이블 삭제 안됨.
-- 자식 레코드 먼저 삭제 후, 부모 레코드 삭제 진행해야하나, 이런 것을 그대로 해주는 옵션이 ON DELETE CASCADE
-- FK제약조건을 지정할 때 ON DELETE CASCADE 옵션을 함께 지정해야 한다.

-- ON DELETE 조건으로 FK 추가.
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno) ON DELETE CASCADE;

DELETE EMPLOYEE WHERE EMPNO=7369;
SELECT * FROM EMPLOYEE;

DELETE DEPARTMENT WHERE DEPTNO =20;
SELECT * FROM DEPARTMENT;




