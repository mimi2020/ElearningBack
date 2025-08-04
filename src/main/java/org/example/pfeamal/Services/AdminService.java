package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Admin;
import org.example.pfeamal.Entities.User;
import org.example.pfeamal.Repositories.AdminRepository;
import org.example.pfeamal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    public Admin createAdmin(Admin user) {
        return  adminRepository.save(user);
    }
    public Admin updateAdmin(Admin user) {
        return  adminRepository.save(user);
    }
    public List<Admin> allAdmin() {
        return adminRepository.findAll();
    }
    public Admin findUserById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
