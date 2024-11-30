# HSTU Classroom Management System
---

**Description:**  
A solution for CRs to arrange a room for scheduled classes at HSTU (D.M.A. Wazed Building).

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Interface](#interface)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The HSTU Class Management System is designed to help Class Representatives (CRs) efficiently manage room bookings for scheduled classes at HSTU, specifically in the D.M.A. Wazed Building.

## Features
- Easy room booking
- Schedule management
- User-friendly interface

## Installation
To install and run this project, follow these steps:

1. Clone the repository or download all the files.
2. Then open the file in the netbeans or other IDE.  
3. Setup sql with mysql workbench or Xampp Control Panel.
4. Create a database named 'cms' using mysql workbench or Xampp .
5. Create 2 Table :
   - crs: It has 6 Columns- id, name, password, contact, department, batch.
   - room: It has 8 columns- id, room_number, course_code, date, start_time, end_time, cr, status.
6. Then change the connection string according to your database in BDConnection.java file.
7. After clean and build then run the start file.

## Interface

![HSTU Logo](https://github.com/Sourav-121/HSTU-Classroom-Management-System/blob/main/Photos/Screenshot%202024-11-30%20103837.png)
---

![HSTU Logo](https://github.com/Sourav-121/HSTU-Classroom-Management-System/blob/main/Photos/Screenshot%202024-11-30%20103927.png)

---

![HSTU Logo](https://github.com/Sourav-121/HSTU-Classroom-Management-System/blob/main/Photos/Screenshot%202024-11-30%20104340.png)

---

![HSTU Logo](https://github.com/Sourav-121/HSTU-Classroom-Management-System/blob/main/Photos/Screenshot%202024-11-30%20104354.png)

---

![HSTU Logo](https://github.com/Sourav-121/HSTU-Classroom-Management-System/blob/main/Photos/Screenshot%202024-11-30%20104418.png)

