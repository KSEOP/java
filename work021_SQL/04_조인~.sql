-- JOIN
-- 여러 테이블로부터 데이터를 가져올 때 사용되는 기법

-- 직원에 대한 정보 얻어오기
SELECT *
FROM EMP;

-- 부서에 대한 정보를 가져옴
SELECT * FROM DEPT;

-- 직원, 부서에 대한 정보를 가져옴

SELECT * FROM EMP, DEPT;
-- 관측해보면, 직원과 부서간의 연결이 제대로 되지 않은, 그냥 단순히 붙여서 곱하기된 형태임.

/*
바로 위 처럼 나온 결과를 Cartesian Product라고 함.
emp와 dept테이블의 단순 수평 결합 결과
14x4 = 56행을 의미함.

이런 Cartesian Product가 도출되는 경우는 2가지임.
1) 조인 조건을 안주는 경우
2) 조인 조건을 잘 못 주면 이렇게 됨.
결론 -- 조인 조건을 잘 주자.
*/

-- STEP 1.
-- 1. 조인 조건은 양쪽 테이블의 공통적인 컬럼이, 조인 조건이 되는 컬럼.
-- 2. 조인조건은 WHERE 절에 지정, =를 사용해서 명시.

-- * 표현은 자제해야한다. Projection 요구됨.
SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- STEP 2. 
-- DEPTNO 어느 테이블을 가져와야 하는지 불확실해 에러도출함
-- 컬럼의 출처를 표기하지 않으면, 양쪽 테이블 전체를 확인하여 성능에 치명적인 영향을 줌.

-- STEP3. 경로테이블 적용
SELECT EMP.empno, EMP.ename, EMP.sal, EMP.DEPTNO, DEPT.DNAME
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
 
-- STEP4.  
SELECT e.empno, e.ename, e.sal, e.DEPTNO, d.DNAME
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO;

-- <사원이름, 급여> e table, 부서번호, <부서이름, 부서위치> d table를 검색
-- 단 급여가 2000 이상이고, 30번 부서에 한해서만, 검색...
SELECT E.ENAME, E.SAL, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = d.deptno
AND
E.SAL >= 2000
AND
D.DEPTNO =30;
-- 조인 조건과 비 조인 조건을 이렇게 이어쓰게됨

-- 뉴욕에서 근무하는 사원의 이름과 급여를 출력
SELECT E.ENAME, E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND
D.LOC = 'NEW YORK';

SELECT * FROM DEPT;







