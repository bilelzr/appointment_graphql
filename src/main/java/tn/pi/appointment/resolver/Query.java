package tn.pi.appointment.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pi.appointment.entities.Appointment;
import tn.pi.appointment.entities.Author;
import tn.pi.appointment.entities.Tutorial;
import tn.pi.appointment.repositories.AppointmentRepository;
import tn.pi.appointment.repositories.AuthorRepository;
import tn.pi.appointment.repositories.TutorialRepository;

@Component
public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;

    private AppointmentRepository appointmentRepository;

    GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
            .aliasedScalar(ExtendedScalars.GraphQLLong)
            .build();

/*    GraphQLScalarType dateScalar = ExtendedScalars.newAliasedScalar("DateTime")
            .aliasedScalar(ExtendedScalars.DateTime)
            .build();*/


    @Autowired
    public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository, AppointmentRepository appointmentRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    public Iterable<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }


}