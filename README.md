Employee Management System (HRMS)
Database Design (Entity Structure)
Core Entities
Users Table

id (PK, AUTO_INCREMENT)
username (UNIQUE)
email (UNIQUE)
password (encrypted)
role (ADMIN, HR_MANAGER, MANAGER, EMPLOYEE)
is_active
created_at, updated_at

Employees Table

id (PK, AUTO_INCREMENT)
user_id (FK to users)
employee_id (UNIQUE, auto-generated)
first_name, last_name, middle_name
date_of_birth
gender (MALE, FEMALE, OTHER)
marital_status (SINGLE, MARRIED, DIVORCED, WIDOWED)
nationality
personal_email, work_email
phone_number, emergency_contact_number
current_address, permanent_address
hire_date, confirmation_date
employment_status (ACTIVE, INACTIVE, TERMINATED)
employment_type (FULL_TIME, PART_TIME, CONTRACT, INTERN)
probation_end_date
termination_date, termination_reason
created_at, updated_at

Departments Table

id (PK, AUTO_INCREMENT)
name (UNIQUE)
description
department_head_id (FK to employees)
parent_department_id (FK to departments - for hierarchy)
budget_allocated
location
is_active
created_at, updated_at

Positions Table

id (PK, AUTO_INCREMENT)
title
description
department_id (FK to departments)
level (JUNIOR, SENIOR, LEAD, MANAGER, DIRECTOR)
min_salary, max_salary
required_skills
is_active
created_at, updated_at

Employee_Positions Table (Employment History)

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
position_id (FK to positions)
department_id (FK to departments)
manager_id (FK to employees)
start_date, end_date
is_current
salary_at_time
created_at, updated_at

Attendance & Time Management
Attendance Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
date
clock_in_time, clock_out_time
break_start_time, break_end_time
total_hours_worked
overtime_hours
status (PRESENT, ABSENT, HALF_DAY, LATE, EARLY_DEPARTURE)
notes
created_at, updated_at

Work_Schedules Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
schedule_name
monday_start, monday_end
tuesday_start, tuesday_end
wednesday_start, wednesday_end
thursday_start, thursday_end
friday_start, friday_end
saturday_start, saturday_end
sunday_start, sunday_end
effective_from, effective_to
is_active

Leave Management
Leave_Types Table

id (PK, AUTO_INCREMENT)
name (ANNUAL, SICK, MATERNITY, PATERNITY, PERSONAL, BEREAVEMENT)
description
max_days_per_year
is_paid
requires_documentation
advance_notice_days
is_active

Leave_Balances Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
leave_type_id (FK to leave_types)
year
allocated_days
used_days
remaining_days
carried_forward_days

Leave_Applications Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
leave_type_id (FK to leave_types)
start_date, end_date
total_days
reason
status (PENDING, APPROVED, REJECTED, CANCELLED)
applied_date
approved_by (FK to employees)
approved_date
rejection_reason
supporting_document_url

Holidays Table

id (PK, AUTO_INCREMENT)
name
date
type (NATIONAL, REGIONAL, COMPANY)
is_optional
description

Payroll Management
Salary_Components Table

id (PK, AUTO_INCREMENT)
name (BASIC_SALARY, HRA, TRANSPORT, MEDICAL, PF, TAX)
type (EARNING, DEDUCTION)
calculation_type (FIXED, PERCENTAGE, FORMULA)
is_taxable
is_active

Employee_Salary_Structure Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
component_id (FK to salary_components)
amount
percentage (if applicable)
effective_from, effective_to
is_active

Payroll_Records Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
pay_period_start, pay_period_end
basic_salary
total_earnings
total_deductions
net_salary
overtime_amount
bonus_amount
tax_deducted
status (DRAFT, PROCESSED, PAID)
processed_date
paid_date

Payslips Table

id (PK, AUTO_INCREMENT)
payroll_record_id (FK to payroll_records)
payslip_number (UNIQUE)
generated_date
file_path
is_sent_to_employee

Performance Management
Performance_Cycles Table

id (PK, AUTO_INCREMENT)
name
start_date, end_date
type (ANNUAL, HALF_YEARLY, QUARTERLY)
status (ACTIVE, COMPLETED, DRAFT)
created_by (FK to employees)

Goals Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
performance_cycle_id (FK to performance_cycles)
title
description
weight_percentage
target_completion_date
status (NOT_STARTED, IN_PROGRESS, COMPLETED, OVERDUE)
achievement_percentage
created_at, updated_at

Performance_Reviews Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
reviewer_id (FK to employees)
performance_cycle_id (FK to performance_cycles)
review_type (SELF, MANAGER, PEER, SUBORDINATE)
overall_rating (1-5)
strengths
areas_for_improvement
goals_for_next_period
status (DRAFT, SUBMITTED, COMPLETED)
submitted_date
created_at, updated_at

Training & Development
Training_Programs Table

id (PK, AUTO_INCREMENT)
title
description
trainer_name
duration_hours
max_participants
cost_per_participant
training_type (INTERNAL, EXTERNAL, ONLINE)
start_date, end_date
location
status (PLANNED, ONGOING, COMPLETED, CANCELLED)

Training_Enrollments Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
training_program_id (FK to training_programs)
enrollment_date
completion_date
status (ENROLLED, COMPLETED, DROPPED, NO_SHOW)
feedback_rating (1-5)
feedback_comments
certificate_issued

Skills Table

id (PK, AUTO_INCREMENT)
name
category (TECHNICAL, SOFT_SKILL, DOMAIN_KNOWLEDGE)
description

Employee_Skills Table

employee_id (FK to employees)
skill_id (FK to skills)
proficiency_level (BEGINNER, INTERMEDIATE, ADVANCED, EXPERT)
years_of_experience
last_assessed_date
PRIMARY KEY (employee_id, skill_id)

Document Management
Document_Types Table

id (PK, AUTO_INCREMENT)
name (RESUME, ID_PROOF, ADDRESS_PROOF, CONTRACT, APPRAISAL)
description
is_mandatory
expiry_applicable

Employee_Documents Table

id (PK, AUTO_INCREMENT)
employee_id (FK to employees)
document_type_id (FK to document_types)
document_name
file_path
upload_date
expiry_date
status (PENDING_VERIFICATION, VERIFIED, REJECTED, EXPIRED)
uploaded_by (FK to employees)

Relationships Summary
One-to-One:

Users ↔ Employees
Employees ↔ Current Position (via Employee_Positions where is_current = true)

One-to-Many:

Departments → Employees
Employees → Attendance Records
Employees → Leave Applications
Employees → Payroll Records
Employees → Performance Reviews
Employees → Training Enrollments

Many-to-Many:

Employees ↔ Skills (via Employee_Skills)
Employees ↔ Training Programs (via Training_Enrollments)
Properties ↔ Amenities (via Property_Amenities)

Self-Referencing:

Employees → Manager (manager_id in Employee_Positions)
Departments → Parent Department (parent_department_id)


Spring Boot Folder Structure
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── company/
│   │           └── hrms/
│   │               ├── HrmsApplication.java
│   │               ├── config/
│   │               │   ├── SecurityConfig.java
│   │               │   ├── JwtConfig.java
│   │               │   ├── DatabaseConfig.java
│   │               │   ├── WebConfig.java
│   │               │   └── SchedulerConfig.java
│   │               ├── controller/
│   │               │   ├── AuthController.java
│   │               │   ├── EmployeeController.java
│   │               │   ├── DepartmentController.java
│   │               │   ├── AttendanceController.java
│   │               │   ├── LeaveController.java
│   │               │   ├── PayrollController.java
│   │               │   ├── PerformanceController.java
│   │               │   ├── TrainingController.java
│   │               │   └── ReportController.java
│   │               ├── dto/
│   │               │   ├── request/
│   │               │   │   ├── LoginRequest.java
│   │               │   │   ├── EmployeeRequest.java
│   │               │   │   ├── AttendanceRequest.java
│   │               │   │   ├── LeaveApplicationRequest.java
│   │               │   │   └── PerformanceReviewRequest.java
│   │               │   ├── response/
│   │               │   │   ├── LoginResponse.java
│   │               │   │   ├── EmployeeResponse.java
│   │               │   │   ├── AttendanceResponse.java
│   │               │   │   ├── PayslipResponse.java
│   │               │   │   └── ApiResponse.java
│   │               │   └── mapper/
│   │               │       ├── EmployeeMapper.java
│   │               │       ├── AttendanceMapper.java
│   │               │       └── LeaveMapper.java
│   │               ├── entity/
│   │               │   ├── User.java
│   │               │   ├── Employee.java
│   │               │   ├── Department.java
│   │               │   ├── Position.java
│   │               │   ├── EmployeePosition.java
│   │               │   ├── Attendance.java
│   │               │   ├── WorkSchedule.java
│   │               │   ├── LeaveType.java
│   │               │   ├── LeaveBalance.java
│   │               │   ├── LeaveApplication.java
│   │               │   ├── Holiday.java
│   │               │   ├── SalaryComponent.java
│   │               │   ├── EmployeeSalaryStructure.java
│   │               │   ├── PayrollRecord.java
│   │               │   ├── Payslip.java
│   │               │   ├── PerformanceCycle.java
│   │               │   ├── Goal.java
│   │               │   ├── PerformanceReview.java
│   │               │   ├── TrainingProgram.java
│   │               │   ├── TrainingEnrollment.java
│   │               │   ├── Skill.java
│   │               │   ├── EmployeeSkill.java
│   │               │   ├── DocumentType.java
│   │               │   └── EmployeeDocument.java
│   │               ├── repository/
│   │               │   ├── UserRepository.java
│   │               │   ├── EmployeeRepository.java
│   │               │   ├── DepartmentRepository.java
│   │               │   ├── AttendanceRepository.java
│   │               │   ├── LeaveApplicationRepository.java
│   │               │   ├── PayrollRecordRepository.java
│   │               │   ├── PerformanceReviewRepository.java
│   │               │   └── TrainingEnrollmentRepository.java
│   │               ├── service/
│   │               │   ├── AuthService.java
│   │               │   ├── EmployeeService.java
│   │               │   ├── DepartmentService.java
│   │               │   ├── AttendanceService.java
│   │               │   ├── LeaveService.java
│   │               │   ├── PayrollService.java
│   │               │   ├── PerformanceService.java
│   │               │   ├── TrainingService.java
│   │               │   ├── EmailService.java
│   │               │   ├── FileStorageService.java
│   │               │   └── ReportService.java
│   │               ├── serviceImpl/
│   │               │   ├── AuthServiceImpl.java
│   │               │   ├── EmployeeServiceImpl.java
│   │               │   ├── AttendanceServiceImpl.java
│   │               │   ├── LeaveServiceImpl.java
│   │               │   ├── PayrollServiceImpl.java
│   │               │   └── ReportServiceImpl.java
│   │               ├── security/
│   │               │   ├── JwtAuthenticationEntryPoint.java
│   │               │   ├── JwtAuthenticationFilter.java
│   │               │   ├── JwtTokenUtil.java
│   │               │   ├── UserPrincipal.java
│   │               │   └── CustomUserDetailsService.java
│   │               ├── exception/
│   │               │   ├── GlobalExceptionHandler.java
│   │               │   ├── ResourceNotFoundException.java
│   │               │   ├── BadRequestException.java
│   │               │   ├── UnauthorizedException.java
│   │               │   └── CustomException.java
│   │               ├── util/
│   │               │   ├── DateUtil.java
│   │               │   ├── ValidationUtil.java
│   │               │   ├── FileUtil.java
│   │               │   ├── PasswordUtil.java
│   │               │   └── Constants.java
│   │               ├── scheduler/
│   │               │   ├── PayrollScheduler.java
│   │               │   ├── AttendanceScheduler.java
│   │               │   └── LeaveBalanceScheduler.java
│   │               └── validation/
│   │                   ├── ValidEmail.java
│   │                   ├── ValidPassword.java
│   │                   ├── EmailValidator.java
│   │                   └── PasswordValidator.java
│   └── resources/
│       ├── application.yml
│       ├── application-dev.yml
│       ├── application-prod.yml
│       ├── static/
│       ├── templates/
│       │   └── email/
│       │       ├── welcome.html
│       │       ├── payslip.html
│       │       └── leave-approval.html
│       └── db/
│           └── migration/
│               ├── V1__Create_users_table.sql
│               ├── V2__Create_employees_table.sql
│               ├── V3__Create_departments_table.sql
│               └── V4__Insert_initial_data.sql
└── test/
    └── java/
        └── com/
            └── company/
                └── hrms/
                    ├── controller/
                    │   ├── EmployeeControllerTest.java
                    │   └── AuthControllerTest.java
                    ├── service/
                    │   ├── EmployeeServiceTest.java
                    │   └── PayrollServiceTest.java
                    ├── repository/
                    │   └── EmployeeRepositoryTest.java
                    └── integration/
                        ├── EmployeeIntegrationTest.java
                        └── AuthIntegrationTest.java