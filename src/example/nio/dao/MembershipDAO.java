package example.nio.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount(){
        System.out.println(getClass() + ": doing some account logic in MembershipDAO");
        return true;
    }
}
