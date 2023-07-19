package com.crio.jukebox.commands;

import java.net.URISyntaxException;
import java.util.List;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.UserService;

public class CreateUserCommand implements ICommand {

    private final IUserService userService;

    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens){
           if(tokens.get(0).equals("CREATE-USER"))
            {  
                User u_obj = userService.create(tokens.get(1));
                System.out.println(u_obj.getId() + " " + u_obj.getUserName());
            }
    }
    
}
