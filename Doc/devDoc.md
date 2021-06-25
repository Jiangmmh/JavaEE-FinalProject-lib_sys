# LibSys开发文档



## 目标

- [x] 用户-当前借阅
- [x] 用户-个人信息



```mysql
SELECT bookName, author, type, borrowDate, returnDate FROM book, borrow_info WHERE book.bookId = borrow_info.bookId AND userId = #{userId};
```



```mysql
SELECT userName, COUNT(*) AS borrowQuantity, o.overDueQuantity , SUM(overDueFine) fine
FROM user u, borrow_info b, 
	(SELECT userId, COUNT(*) overDueQuantity
   	 FROM user u, borrow_info b
     WHERE u.userId = b.userId AND b.isOverDue = "已逾期") o
WHERE u.userid = b.userid, b.userid = o.userid
GROUP BY b.userid;
```





```mysql
SELECT userName, COUNT(*) AS borrowQuantit, SUM(overDueFine) fine
FROM user u, borrow_info b
WHERE u.userid = b.userid
GROUP BY b.userid;

SELECT b.userid, COUNT(*) totalBorrow, SUM(overDueFine) fine
FROM user u, borrow_info b
WHERE u.userid = b.userid
GROUP BY b.userid

UNION
SELECT userName, COUNT(*) totalBorrows, SUM(overDueFine) fine
FROM user u, borrow_info b
WHERE u.userid = b.userid
GROUP BY b.userid;

SELECT userid, COUNT(*) FROM borrow_info 
WHERE isOVerDue = '已逾期'
GROUP BY userid;
```



## 数据表

user：

| 编号 |  字段名  |  类型   | 长度 | 是否为主键 | 是否为非空 | 是否唯一 |
| :--: | :------: | :-----: | :--: | :--------: | :--------: | :------: |
|  1   |  userId  |   INT   |  ~   |     是     |     是     |    是    |
|  2   | userName | VARCHAR |  20  |     否     |     是     |    是    |
|  3   | password | VARCHAR |  20  |     否     |     是     |    否    |
|  4   | identity | VARCHAR |  10  |     否     |     是     |    否    |
|  5   |          |         |      |            |            |          |

```mysql
CREATE TABLE IF NOT EXISTS user(
	userId INT AUTO_INCREMENT NOT NULL,
    userName VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    identity VARCHAR(10) NOT NULL,
    PRIMARY KEY (userId)
);
```



book：

| 编号 |    字段名     |  类型   | 长度 | 是否为主键 | 是否为非空 | 是否唯一 |
| :--: | :-----------: | :-----: | :--: | :--------: | :--------: | :------: |
|  1   |    bookId     |   INT   |  ~   |     是     |     是     |    是    |
|  2   |   bookName    | VARCHAR |  40  |     否     |     是     |    否    |
|  3   |    author     | VARCHAR |  20  |     否     |     是     |    否    |
|  4   | totalQuantity |   INT   |  ~   |     否     |     是     |    否    |
|  5   |  remQuantity  |   INT   |  ~   |     否     |     是     |    否    |
|  6   |     type      | VARCHAR |  20  |     否     |     是     |    否    |
|      |               |         |      |            |            |          |

```mysql
CREATE TABLE IF NOT EXISTS book(
	bookId INT AUTO_INCREMENT NOT NULL,
    bookName VARCHAR(40) NOT NULL UNIQUE,
    author VARCHAR(20) NOT NULL,
    totalQuantity INT NOT NULL,
    remQuantity INT NOT NULL,
    type VARCHAR(20) NOT NULL,
    PRIMARY KEY (bookId)
);

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('深入理解计算机系统', '布莱恩特&奥哈拉伦', 10, 10, '计算机');

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('现代操作系统', '坦恩伯姆', 2, 2, '计算机');

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('乡土中国', '费孝通', 5, 5, '社会学');

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('连城诀', '金庸', 32, 32, '中国文学');

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('热爱生命', '杰克·伦敦', 3, 3, '外国文学');

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('维特根斯坦传-天才之为责任', '瑞·蒙克', 2, 2, '哲学');

INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
VALUES('哲学的故事', '威尔·杜兰特', 4, 4, '哲学');

```



book_type:

| 编号 | 字段名 |  类型   | 长度 | 是否为主键 | 是否为非空 | 是否唯一 |
| :--: | :----: | :-----: | :--: | :--------: | :--------: | :------: |
|  1   |   id   |   INT   |  ~   |     是     |     是     |    是    |
|  2   |  type  | VARCHAR |  20  |     否     |     是     |    否    |
|      |        |         |      |            |            |          |
|      |        |         |      |            |            |          |
|      |        |         |      |            |            |          |

​	

```mysql
CREATE TABLE IF NOT EXISTS book_type(
	id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    type VARCHAR(20) NOT NULL UNIQUE,
    quantity INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO book_type(type, quantity) VALUES('计算机', 12);
INSERT INTO book_type(type, quantity) VALUES('社会学', 5);
INSERT INTO book_type(type, quantity) VALUES('哲学', 6);
INSERT INTO book_type(type, quantity) VALUES('外国文学', 3);
INSERT INTO book_type(type, quantity) VALUES('中国文学', 32);

```



borrow_info：

| 编号 |   字段名   |   类型   | 长度 | 是否为主键 | 是否为非空 | 是否唯一 |
| :--: | :--------: | :------: | :--: | :--------: | :--------: | :------: |
|  1   |  borrowId  |   INT    |  ~   |     是     |     是     |    是    |
|  2   |   userId   |   INT    |  ~   |     否     |     是     |    否    |
|  3   |   bookId   | VARCHAR  |  20  |     否     |     是     |    否    |
|  4   | borrowDate | DATETIME |  ~   |     否     |     是     |    否    |
|  5   | returnDate | DATETIME |  ~   |     否     |     是     |    否    |
|      |            |          |      |            |            |          |

```mysql
    CREATE TABLE IF NOT EXISTS borrow_info(
        borrowId INT AUTO_INCREMENT NOT NULL,
        userId INT NOT NULL,
        bookId INT NOT NULL,
        borrowDate DATETIME NOT NULL,
        returnDate DATETIME NOT NULL,
        isOverDue VARCHAR(10) DEFAULT "未逾期",
        OverDueFine DOUBLE DEFAULT 0,
        PRIMARY KEY (borrowId)
    );
```





## 问题：

#### 1. 向Mysql中存储日期的问题：

**如何存?**

使用java提供的`TimeStamp`对象来存储日期。

```
Date date = new Date();
TimeStamp timeStamp = new TimeStamp(date.getTime());
```



**如何对当前日期增加30天得到还书日期？**

利用Calendar对象来完成该功能：

```java
Calendar calendar = Calendar.getInstance();
Timestamp borrowDate = new Timestamp(calendar.getTime().getTime());
calendar.add(Calendar.DATE, 30);
Timestamp returnDate = new Timestamp(calendar.getTime().getTime());
```



```mysql
 INSERT INTO book(bookName, author, totalQuantity, remQuantity, type)
 VALUES('深入解析Windows操作系统', '罗斯&所罗门', 2, 2, '计算机');
```

```
罗斯&amp;所罗门
```

