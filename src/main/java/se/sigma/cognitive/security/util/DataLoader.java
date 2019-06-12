package se.sigma.cognitive.security.util;

import org.hibernate.mapping.Array;
import se.sigma.cognitive.security.model.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DataLoader {



    public static final List<Role>   PARTNER_ROLES=new ArrayList<>(Arrays.asList(new Role("ROLE_PARTNER"), new Role("ROLE_ADMIN"), new Role("ROLE_USER")));
    public static  List<Role>   ADMIN_ROLES=new ArrayList<>(Arrays.asList(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));
}
