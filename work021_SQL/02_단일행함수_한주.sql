-- IN ������
-- �������� �� �߿��� ��� �ϳ��� ���� ��ġ�ϴ����� ��

-- �����ȣ�� 7369 �̰ų� 7521 �̰ų� 7782���� ����� �˻�
--1 Step
SELECT * FROM emp WHERE empno = 7369;
SELECT * FROM emp WHERE empno = 7521;
SELECT * FROM emp WHERE empno = 7782;

--2 Step
SELECT * FROM emp WHERE empno = 7782 OR empno = 7521 OR empno = 7369;

--3 Step
SELECT * FROM emp WHERE empno IN (7782,7521,7369);

-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
--�����ȣ�� 7369�� �ƴϰ� 7521 �ƴϰ� 7782 �ƴ� ����� �˻�
SELECT * FROM emp WHERE empno NOT IN (7782,7521,7369);

-- NULL�� �ɷ����� �����.
SELECT * FROM emp WHERE empno != 7782 AND empno != 7521 AND empno != 7369;


--���� �Լ�::SUBSTR(  )
--SUBSTR(���ڿ�, ���� ��ġ, ����)
select SUBSTR('HelloWorld',6) From dual;
select SUBSTR('HelloWorld',6,3) From dual;
select SUBSTR('HelloWorld',-4,2) From dual;

-- emp ���̺��� ����� �̸��� N���� ������ ����� �˻�
select ename from emp where substr(ename,-1,1) = 'N';
select ename from emp where substr(lower(ename),-1,1) = 'n';
select ename from emp where ename like '%N';

-- emp ���̺��� ������� �Ի�⵵�� �˻�
SELECT hiredate, substr(hiredate,1,2)  �Ի�⵵ from emp;

-- TRIM() : ������ �����ϴ� �Լ�
SELECT rtrim('JAMES GOSLING              ') from dual;
SELECT ltrim('              JAMES GOSLING') from dual;
SELECT trim('              JAMES GOSLING            ') from dual;


--REPLACE() : ��ü
select replace(job,'MAN','PERSON') NewJob from emp where job = 'SALESMAN';
select replace('              JAMES         GOSLING            ',' ','') from dual;

--�����Լ�
--ROUND

/*
2��° ���ڰ� 2�� �ǹ̴� �Ҽ��� ���� 2�ڸ����� ���ڸ� ��Ÿ����� ��
�̷��� �Ǳ� ���ؼ��� �Ҽ��� ���� 3�ڸ����� ���������� �ݿø��� �����
*/
SELECT ROUND(45.923,2) FROM dual; -- 45.92
SELECT ROUND(45.923,0) FROM dual; -- 46
SELECT ROUND(45.923) FROM dual; -- 46
/*
�ι�° ���ڰ��� ������ ����
.(��)�� �߽����� ��, ��, ��, õ.... ������ �Ž��� �ö�

����� ���� �޸� �ش� �ڸ����� �ٷ� �ݿø� �Ͼ.
*/
SELECT ROUND(45.923,-1) FROM dual;  -- 50

-- FLOOR() :: ����(�Ҽ��� �Ʒ��� ����)
SELECT FLOOR(45.923) FROM dual;

-- SELECT FLOOR(45.923,2) FROM dual; Floor()�� �ڸ��� ������ ���� ����.

--TRUNC() :: �ڸ����� ����, ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923) FROM dual;
SELECT TRUNC(45.923,0) FROM dual;
SELECT TRUNC(45.923,2) FROM dual;

--CEIL() :: �ø� / FLOOR()�� �ݴ� :: �ڸ��� ���� �ȵ�.
-- ��, ������ ��������� ��Ÿ��
SELECT CEIL(45.923) FROM dual;

SELECT GREATEST(1,2,3) FROM dual;
SELECT LEAST(1,2,3) FROM dual;

-- ��¥ �Լ�
SELECT SYSDATE FROM dual;
SELECT SYSTIMESTAMP FROM dual;

-- ���̸� ������ 100��° �Ǵ� �� ��� ��
SELECT SYSDATE + 100 FROM dual;

-- ����
SELECT SYSDATE + 1 ���� FROM dual;

-- ����
SELECT SYSDATE - 1 ���� FROM dual;
-- �����е��� �׵��� ��ƿ��� ����
SELECT TRUNC(SYSDATE - TO_DATE('00/02/29')) FROM dual;

SELECT extract (day from sysdate) ����, extract(month from sysdate) ��, extract (year from sysdate) �⵵ FROM dual;

SELECT ename, hiredate, extract(year from hiredate) year,
extract(day from hiredate) day
from emp
where deptno = 20;

SELECT ename, hiredate, sysdate, months_between(sysdate,hiredate) m_between,
trunc(months_between(sysdate,hiredate),0) t_between
FROM emp
WHERE deptno = 10
ORDER BY months_between(sysdate,hiredate) desc;

SELECT ename, hiredate, next_day(hiredate,'�ݿ���') n_6,
next_day(hiredate,7) n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate desc;

-- ��¥�� ��¥ ������ ���� �� :: MONTHS_BETWEEND(DAY1, DAY2)
-- EMP ���̺��� �Ի��� ���κ��� "2023/07/25" ���� ��
-- ���� to_date�� ���� �ʾƵ� ��
SELECT abs(trunc(months_between(hiredate, '23/07/25'))) as ������ from emp;


-- ��ȯ �Լ�
-- �޿��� 3�ڸ����� , ���
SELECT empno, ename, job, sal, to_char(sal,'999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

-- EMP ���̺��� 20�� �μ� �� �Ի� ���ڸ� '1998�� 1�� 1��'�� ���·� ����Ͽ���
SELECT ename, hiredate, to_char(hiredate, 'YYYY"�� "MM"�� "DD"��" ') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate desc;

-- to_number()
SELECT '0001230' ���1, to_number('001230') ���2 FROM dual;


--�Ϲ��Լ� : DECODE()
-- EMP���̺��� ������ PRESIDENT / ����
--                                    MANAGER / ������,
--                                    ANALYST / �м���,
--                                    ��Ÿ        / ����
--                                    �����з�
SELECT
DECODE( job,
'PRESIDENT','����',
'MANAGER','������',
'ANALYST','�м���',
'����'
) �����з�
FROM emp;

SELECT
DECODE( sal,
5000,'OWNER  �޿�',
3000,'������',
'�Ϲ� �޿�'
) �޿�����
FROM emp;


SELECT
DECODE( sal,
5000,'OWNER  �޿�',
3000,'������',
'�Ϲ� �޿�'
) �޿�����
FROM emp;

SELECT ename, sal,
CASE WHEN sal = 5000 THEN 'OWNER �޿�'
    WHEN sal = 3000 THEN '��� �޿�'
    ELSE '�Ϲ� �޿�'
    END �޿�����
FROM emp;    