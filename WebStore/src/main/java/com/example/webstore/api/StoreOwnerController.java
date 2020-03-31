package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserNotFoundException;
import com.example.webstore.model.StoreOwner;
import com.example.webstore.service.StoreOwnerService;
import com.example.webstore.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app")
public class StoreOwnerController {
    @Resource
    StoreOwnerService storeOwnerService;
    @Resource
    UserService userService;

    @PostMapping(value = "/createStoreOwner")
    public String addStoreOwner(@RequestBody StoreOwner storeOwner) {
        if(userService.getUserByUserName(storeOwner.getUserName())!=null){
            throw new SignUpUserNotFoundException();
        }
        else{
            userService.insertUser(storeOwner);
            storeOwnerService.insertStoreOwner(storeOwner);
            return "SignUp Successfully";
        }
    }
    @GetMapping(path = "/loginStoreOwner/{userName}/{pw}")
    public StoreOwner loginStoreOwner(@PathVariable("userName") String userName, @PathVariable("pw") String pw){
        StoreOwner storeOwner=storeOwnerService.loginStoreOwner(userName,pw);
        if(storeOwner==null){
            throw new LoginUserNotFoundException();
        }
        return storeOwner;
    }

    @GetMapping(value = "/storeOwnerList")
    public List<StoreOwner> getStoreOwners() {
        return storeOwnerService.findAll();
    }

    @PutMapping(value = "/updateStoreOwner")
    public void updateStoreOwner(@RequestBody StoreOwner storeOwner) {
        storeOwnerService.updateStoreOwner(storeOwner);
    }

    @PutMapping(value = "/executeUpdateStoreOwner")
    public void executeUpdateStoreOwner(@RequestBody StoreOwner storeOwner) {
        storeOwnerService.executeUpdateStoreOwner(storeOwner);
    }

    @DeleteMapping(value = "/deleteStoreOwner")
    public void deleteStoreOwner(@RequestBody StoreOwner storeOwner) {
        userService.deleteUser(storeOwner);
    }
}