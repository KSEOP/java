-- 분석함수
-- OVER 함수는, ORDER BY 절 뒤에 작동한다.
SELECT EMPNO, ENAME, DEPTNO, SAL,
RANK() OVER(ORDER BY SAL DESC) "RANK" -- 급여순으로 정렬을 하고 나서 RANK함.
FROM EMP; -- 2등에 동점자가 있을 때, 3을 SKIP하고 다음으로 4순위가 온다.


SELECT EMPNO, ENAME, DEPTNO, SAL,
DENSE_RANK() OVER(ORDER BY SAL DESC) "RANK"
FROM EMP;  -- 동점자가 있어도, RANK 번호를 SKIP 하지 않는다.

SELECT EMPNO, ENAME, DEPTNO, SAL,
DENSE_RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) "RANK"
FROM EMP; -- 그루핑한 DEPTNO 내부에서 순위를 따로 돌림.
-- GROUP BY와의 차이점. 
-- GROUP BY는 "특정 그룹" 에서 "집계된" "하나의 값" 을 도출함.
-- 반면 PARTITION BY 는 SUM을 써도, 모든 행마다 값을 표시함.

-- 분석 함수가 OVERHEAD를 줄여준다 -- 성능이 좋다. -- JOINSUBQUERY가 줄어든다.

-- STEP 1. 제대로 되지 않은 ROWNUM
SELECT ENAME, SAL, ROWNUM FROM EMP ORDER BY SAL DESC;

-- STEP 2.
SELECT ENAME, SAL, ROWNUM
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM <=3; -- ROWNUM은 ~ 이상 값은 안된다. 무조건 ~ 이하 값만가능. POINTING도 안됨.

-- STEP 3. ROW_NUMBER() OVER() 함께 사용해서 STEP과 동일한 결과 출력
SELECT ENAME, SAL, ROW_NUMBER() OVER (ORDER BY SAL DESC) 급여랭킹
FROM EMP;

-- ROW_NUMBER()
-- GROUP BY, ORDER BY 절에서 지정된 행의 순서를 할당하는 분석 함수.

SELECT ENAME, SAL, HIREDATE,
ROW_NUMBER() OVER(ORDER BY SAL DESC, HIREDATE ASC) 순번
FROM EMP;

SELECT ENAME, SAL, HIREDATE,
ROW_NUMBER() OVER(ORDER BY SAL DESC) 순번
FROM EMP; -- ROW_NUMBER는 랭킹이 아닌 순번을 매기는 것일 뿐이므로, UNIQUE 하게 나옴.
-- 그래서 동률일 경우를 감안하여 2중으로 정렬 기준을 두는게 적절할 수 있음.




