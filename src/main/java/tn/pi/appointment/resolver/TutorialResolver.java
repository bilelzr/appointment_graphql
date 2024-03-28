package tn.pi.appointment.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pi.appointment.entities.Author;
import tn.pi.appointment.entities.Tutorial;
import tn.pi.appointment.repositories.AuthorRepository;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
    @Autowired
    private AuthorRepository authorRepository;

    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Tutorial tutorial) {
            return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }

}