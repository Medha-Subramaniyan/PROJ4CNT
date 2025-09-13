# Project 4 - Three-Tier Distributed Web-Based Application

**Course:** CNT 4714 - Summer 2025  
**Author:** Medha Subramaniyan  
**Date:** July 31, 2025  
**Assignment:** A Three-Tier Distributed Web-Based Application

## Overview

This is a comprehensive three-tier distributed web application built with Java servlets, JSP, and MySQL database. The application implements a supplier-parts-jobs-shipments database system with role-based access control and business logic triggers.

## Architecture

The application follows a three-tier architecture:

1. **Presentation Tier**: JSP pages and HTML forms
2. **Business Logic Tier**: Java servlets handling authentication and business rules
3. **Data Tier**: MySQL database with multiple schemas and user permissions

## Features

### User Authentication & Role-Based Access
- **Root User**: Full database privileges, can trigger business logic
- **Client User**: Read-only access to project4 database
- **Accountant User**: Execute stored procedures only
- **System App**: Manages credentials database

### Business Logic
- Automatic supplier status updates when shipment quantities ≥ 100
- Real-time database monitoring and updates
- Error handling and SQL exception management

### Database Management
- Multi-schema database design (project4, credentialsDB)
- Stored procedures for complex queries
- Foreign key constraints and referential integrity
- User permission management

## Database Schema

### Project4 Database
- **suppliers**: Supplier information (snum, sname, status, city)
- **parts**: Parts catalog (pnum, pname, color, weight, city)
- **jobs**: Job information (jnum, jname, numworkers, city)
- **shipments**: Shipment transactions (snum, pnum, jnum, quantity)

### CredentialsDB Database
- **usercredentials**: User authentication (login_username, login_password)

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Apache Tomcat 10.1.43
- MySQL Server 8.0 or higher
- MySQL Connector/J 8.0.33

### Database Setup

1. **Create the Project4 Database:**
   ```bash
   mysql -u root -p < project4DBscript.sql
   ```

2. **Create the Credentials Database:**
   ```bash
   mysql -u root -p < credentialsDBscript.sql
   ```

3. **Set up User Permissions:**
   ```bash
   mysql -u root -p < ClientCreattionPermissionsScript.sql
   ```

4. **Update Root Password:**
   Edit `credentialsDBscript.sql` and change the root password:
   ```sql
   insert into usercredentials values ("root", "your_password_here");
   ```

### Application Deployment

1. **Extract Tomcat:**
   ```bash
   tar -xzf apache-tomcat-10.1.43.tar.gz
   ```

2. **Configure Database Connections:**
   Update the properties files in `webapps/Project4/WEB-INF/conf/`:
   - `root.properties`
   - `client.properties`
   - `accountant.properties`
   - `systemapp.properties`

3. **Start Tomcat:**
   ```bash
   cd apache-tomcat-10.1.43/bin
   ./startup.sh
   ```

4. **Access the Application:**
   Navigate to `http://localhost:8080/Project4/`

## Usage

### Authentication
1. Access the login page at `http://localhost:8080/Project4/authentication.html`
2. Use one of the following credentials:
   - **Root**: username: `root`, password: `rootMAC1$`
   - **Client**: username: `client`, password: `client`
   - **Accountant**: username: `theaccountant`, password: `theaccountant`

### User Capabilities

#### Root User
- Execute any SQL command on project4 database
- Trigger business logic when shipment quantities ≥ 100
- Full CRUD operations on all tables
- Access to all database functions

#### Client User
- Read-only access to project4 database
- Execute SELECT queries only
- Cannot modify data or trigger business logic

#### Accountant User
- Execute stored procedures only
- Access to predefined business functions
- Limited to specific database operations

### Testing Commands

#### Root User Commands
Run the commands in `project4rootcommands.sql` to test:
- Complex queries with business logic triggers
- Multi-part transactions
- Error handling scenarios

#### Client User Commands
Run the commands in `project4clientcommands.sql` to test:
- Read-only operations
- Permission restrictions
- Query capabilities

## File Structure

```
PROJ4CNT/
├── apache-tomcat-10.1.43/          # Tomcat server
│   └── webapps/
│       └── Project4/               # Web application
│           ├── authentication.html # Login page
│           ├── rootHome.jsp        # Root user interface
│           ├── clientHome.jsp      # Client user interface
│           ├── accountantHome.jsp  # Accountant user interface
│           ├── errorpage.html      # Error page
│           └── WEB-INF/
│               ├── classes/        # Java servlets
│               ├── conf/          # Database configuration
│               └── web.xml        # Web application configuration
├── project4DBscript.sql            # Main database schema
├── credentialsDBscript.sql        # Authentication database
├── ClientCreattionPermissionsScript.sql # User permissions
├── project4rootcommands.sql       # Root user test commands
├── project4clientcommands.sql     # Client user test commands
└── README.md                      # This file
```

## Key Components

### Servlets
- **AuthenticationServlet**: Handles user login and session management
- **RootServlet**: Processes root user SQL commands and business logic
- **ClientServlet**: Handles client user read-only operations
- **AccountantServlet**: Manages accountant user stored procedure execution
- **TestDriverServlet**: Tests MySQL driver connectivity

### Database Utilities
- **DBConnectionUtil**: Centralized database connection management
- Properties-based configuration for different user types
- Connection pooling and resource management

### Business Logic
- Automatic supplier status updates
- Shipment quantity monitoring
- Real-time database triggers
- Error handling and logging

## Security Features

- Role-based access control
- Database user permissions
- SQL injection prevention
- Session management
- Secure authentication

## Troubleshooting

### Common Issues

1. **Database Connection Errors:**
   - Verify MySQL server is running
   - Check database credentials in properties files
   - Ensure MySQL Connector/J is in Tomcat lib directory

2. **Permission Denied Errors:**
   - Run the permissions script: `ClientCreattionPermissionsScript.sql`
   - Verify user accounts exist in MySQL
   - Check database user privileges

3. **Tomcat Startup Issues:**
   - Check Java version compatibility
   - Verify port 8080 is available
   - Review Tomcat logs in `logs/` directory
