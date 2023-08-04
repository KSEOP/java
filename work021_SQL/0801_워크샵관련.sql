-- �뷮�� ���õ����� ����
-- CTAS (Create Table AS Select)
-- emp/dept ���� ���̺��� �����͸� �״�� ���÷� �޾ƿͼ� ���ο� ���̺��� ����.
SELECT * FROM EMP;

-- EMP1 ���̺� ����.
CREATE TABLE EMP1
AS
(SELECT * FROM EMP);


SELECT * FROM EMP1;

-- EMP2 ���̺� ����
CREATE TABLE EMP2
AS
(SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP);

SELECT * FROM EMP2;

-- EMP3 ���̺� ����
CREATE TABLE EMP3
AS
(SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
WHERE DEPTNO = '10');

SELECT * FROM EMP3;

DESC EMP1;
-- CTAS�� ������ �״�� ����������, ���������� �������� �ʴ´�(PK ��)

/*
INSERT / DELETE / UPDATE


*/
-- NUMBER(7, 2) -- ��ü �ڸ��� 7�ڸ�, ���� �Ҽ��� ���ϴ� 2�ڸ� ���� Ŀ���ϰڴ� (=������ 5�ڸ� ���� Ŀ��)
DESC EMP3;

SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP3;

-- 1. INSERT
INSERT INTO EMP3 (EMPNO, ENAME, SAL, DEPTNO) VALUES(1111,'JAMES',2800,20);
-- �׳� VALUES�� �ᵵ �Ǳ��ϳ�, �տ� (//) ä���ִ°� �� ��Ȯ�ϱ� �ϴ�.


-- 2. UPDATE :: 1111 ����� ����� ������ ���� / 2800 --> 2900, 20 --> 10 ���� ����
-- *** EMPNO(PK) �÷��� ������ ����� �ƴϴ�. �� PK�� ������ ������ �÷��� ������ ����� �ȴ�.
-- UPDATE���� DML �߿��� ������ Ʋ�� �� �ִ� ������ ���� ����. ���� �ʿ�.

UPDATE EMP3 SET ENAME='JAMES', SAL=2900, DEPTNO=10 WHERE EMPNO = 1111;
-- , �޸��� �����Կ� ����

--3. DELETE :: 1111 ����� ���� ����� ����
--1) WHERE �ο�  2) WHERE ���� ���ϴ� ���
DELETE EMP3 WHERE EMPNO=1111;
-- WHERE�� ���ָ� �� ������. �� ���ʿ� WHERE�� �༭ ����°� DELETE�� �뵵��.

SELECT * FROM EMP2;

-- ������ �����ϱ�

CREATE SEQUENCE ora_seq
start with 1
increment BY 1;

select ora_seq.nextVal FROM DUAL;

SELECT ORA_SEQ.CURRVAL FROM DUAL;

SELECT ORA_SEQ.NEXTVAL FROM DUAL;

CREATE SEQUENCE SEQ_MYMEMBER START WITH 1 INCREMENT BY 1;

CREATE TABLE MYMEMBER(
NO NUMBER PRIMARY KEY,
NAME VARCHAR2(30));

INSERT INTO MYMEMBER (NO, NAME) VALUES(SEQ_MYMEMBER.NEXTVAL, 'ȫ�浿');

INSERT INTO MYMEMBER (NO, NAME) VALUES(SEQ_MYMEMBER.NEXTVAL, '������');

SELECT * FROM MYMEMBER;

COMMIT;

CREATE TABLE MEMBER (
ID NUMBER PRIMARY KEY,
NAME VARCHAR2(20),
EMAIL VARCHAR2(30),
PHONE VARCHAR2(30));

CREATE SEQUENCE SEQ_ID INCREMENT BY 1 START WITH 1;

COMMIT;


