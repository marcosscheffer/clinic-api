create table consults (
    id bigint not null auto_increment,
    date datetime not null,
    patient_id bigint not null,
    doctor_id bigint not null,
    primary key (id),
    constraint fk_consults_patient_id foreign key (patient_id) references patients (id),
    constraint fk_consults_doctor_id foreign key (doctor_id) references doctors (id)
)