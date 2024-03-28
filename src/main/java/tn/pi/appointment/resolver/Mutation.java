package tn.pi.appointment.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pi.appointment.entities.Appointment;
import tn.pi.appointment.entities.Author;
import tn.pi.appointment.entities.Tutorial;
import tn.pi.appointment.entities.UpdateAppointmentInput;
import tn.pi.appointment.repositories.AppointmentRepository;
import tn.pi.appointment.repositories.AuthorRepository;
import tn.pi.appointment.repositories.TutorialRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;
    private AppointmentRepository appointmentRepository;

    String dateTimeString = "2024-03-28T10:15:30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    @Autowired
    public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository, AppointmentRepository appointmentRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        authorRepository.save(author);

        return author;
    }

    public Tutorial createTutorial(String title, String description, Long authorId) {
        Tutorial tutorial = new Tutorial();
        tutorial.setAuthor(new Author(authorId));
        tutorial.setTitle(title);
        tutorial.setDescription(description);

        tutorialRepository.save(tutorial);

        return tutorial;
    }
    public Appointment createAppointment(long clientId, long agentId, long propertyId,
                                         String dateTime,String description) {
        LocalDateTime dateTime1 = LocalDateTime.parse(dateTimeString, formatter);

        Appointment appointment = new Appointment();
        appointment.setDescription(description);
        appointment.setClientId(clientId);
        appointment.setPropertyId(propertyId);
        appointment.setAgentId(agentId);
        appointment.setDateTime(dateTime1);
        appointment.setStatus("PENDING");
        appointmentRepository.save(appointment);

        return appointment;
    }
    public boolean deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
        return true;
    }
    public boolean deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(Long id, String title, String description) throws EntityNotFoundException {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

        if (optTutorial.isPresent()) {
            Tutorial tutorial = optTutorial.get();

            if (title != null)
                tutorial.setTitle(title);
            if (description != null)
                tutorial.setDescription(description);

            tutorialRepository.save(tutorial);
            return tutorial;
        }

        throw new EntityNotFoundException("Not found Tutorial to update!");
    }

    public Appointment updateAppointment(UpdateAppointmentInput input) throws EntityNotFoundException {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(input.getId());

        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();


            if (input.getDescription() != null)
                appointment.setDescription(input.getDescription());
            if (input.getStatus() != null )
                appointment.setStatus(input.getStatus());
            appointmentRepository.save(appointment);
            return appointment;
        }

        throw new EntityNotFoundException("Not found Tutorial to update!");
    }

}