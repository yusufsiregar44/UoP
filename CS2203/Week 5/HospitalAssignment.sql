CREATE TABLE Doctor(
    DoctorId int auto_increment PRIMARY KEY NOT NULL,
    DoctorName varchar(30) NOT NULL,
    Phone varchar(30) NOT NULL,
    SpecialtyNumber int,
    Supervisor int,
    FOREIGN KEY (Supervisor) REFERENCES Doctor(DoctorId),
    FOREIGN KEY (SpecialtyNumber) REFERENCES Specialty(SpecialtyNumber)
);

CREATE TABLE Specialty(
    SpecialtyNumber int auto_increment PRIMARY KEY NOT NULL,
    SpecialtyName varchar(30) NOT NULL
);

CREATE TABLE Patient(
    PatientId int auto_increment PRIMARY KEY NOT NULL,
    Name varchar(30) NOT NULL,
    Phone varchar(30) NOT NULL,
    Email varchar(30),
    Address varchar(30) NOT NULL,
    AddedDate TIMESTAMP NOT NULL,
    DoctorId int,
    FOREIGN KEY (DoctorId) REFERENCES Doctor(DoctorId)
);

CREATE TABLE Allergy(
    AllergyId int Primary Key NOT NULL,
    AllergyName varchar(30) NOT NULL
);

CREATE TABLE PatientAllergy(
    AllergyId int NOT NULL,
    PatientId int NOT NULL,
    PRIMARY KEY (AllergyId, PatientId),
    FOREIGN KEY (AllergyId) REFERENCES Allergy(AllergyId),
    FOREIGN KEY (PatientId) REFERENCES Patient(PatientId)
);

CREATE TABLE Appointment(
    AppointmentId int auto_increment PRIMARY KEY NOT NULL,
    DoctorId int NOT NULL,
    AppointmentDate Timestamp NOT NULL,
    BloodPressure int NOT NULL,
    Weight int NOT NULL,
    TreatmentNotes VARCHAR(30) NOT NULL,
    FOREIGN KEY (DoctorId) REFERENCES Doctor(DoctorId)
);


CREATE TABLE PatientMedicine(
    AppointmentId int NOT NULL,
    MedicineId int NOT NULL,
    PRIMARY KEY (AppointmentId, MedicineId),
    FOREIGN KEY (AppointmentId) REFERENCES Appointment(AppointmentId),
    FOREIGN KEY (MedicineId) REFERENCES Medicine(MedicineId)
);

CREATE TABLE Medicine(
    MedicineId int auto_increment PRIMARY KEY NOT NULL,
    MedicineName varchar(30) NOT NULL
);

