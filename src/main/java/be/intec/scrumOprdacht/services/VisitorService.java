package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public void createVisitor(User visitor){
        System.out.println(visitor);
        visitorRepository.save(visitor);
    }

    public User getVisitorByNameAndPassword(String visitorName, String passWord){

        return visitorRepository.findVisitorByNameAndPassWord(visitorName,passWord);
    }
}
