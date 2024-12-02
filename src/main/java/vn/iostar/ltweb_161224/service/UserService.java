package vn.iostar.ltweb_161224.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iostar.ltweb_161224.model.user;
import vn.iostar.ltweb_161224.repository.iUserRepos;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    iUserRepos userRepos;

    public Optional<user> findById(Long userId) {
        return userRepos.findById(userId);
    }

    public List<user> findAllUsers() {
        return userRepos.findAll();
    }

    public user saveUser(user user) {
        return userRepos.save(user);
    }

    public user updateUser(user userDetails) {
        return userRepos.findById(userDetails.getId())
                .map(user -> {
                    user.setFullname(userDetails.getFullname());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    user.setPhone(userDetails.getPhone());
                    return userRepos.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        if (!userRepos.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepos.deleteById(id);
    }
}
