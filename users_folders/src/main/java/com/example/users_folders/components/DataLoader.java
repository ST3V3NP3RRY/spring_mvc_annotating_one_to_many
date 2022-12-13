package com.example.users_folders.components;

import com.example.users_folders.models.File;
import com.example.users_folders.models.Folder;
import com.example.users_folders.models.User;
import com.example.users_folders.repositories.FileRepository;
import com.example.users_folders.repositories.FolderRepository;
import com.example.users_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public void run(ApplicationArguments args) {

        User ray = new User("Ray Stevens");
        userRepository.save(ray);

        User shirley = new User("Shirley Bassey");
        userRepository.save(shirley);

        User terry = new User("Terry Butcher");
        userRepository.save(terry);

        Folder pictures = new Folder("Pictures", terry);
        folderRepository.save(pictures);

        Folder accounts = new Folder("Accounts", shirley);
        folderRepository.save(accounts);

        File holiday_img = new File("holiday",".jpg", 400, pictures );
        fileRepository.save(holiday_img);

        File company_accounts = new File("company_accounts", ".txt", 200, accounts);
        fileRepository.save(company_accounts);
    }
}
