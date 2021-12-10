package com.example.billing.service;

import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

//TODO: пока что такие говенные тесты
@SpringBootTest
@Testcontainers
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        var user = new UserEntity();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");

        var result = userService.addUser(user);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getId());
        Assert.assertEquals(user.getName(), result.getName());
        Assert.assertEquals(user.getSurname(), result.getSurname());
    }

    @Test
    public void testUpdateUser() {
        var user = new UserEntity();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");

        var addResult = userService.addUser(user);
        Assert.assertNotNull(addResult);
        Assert.assertNotNull(addResult.getId());
        Assert.assertEquals(user.getName(), addResult.getName());
        Assert.assertEquals(user.getSurname(), addResult.getSurname());

        final String newName = "Олег";
        addResult.setName(newName);

        var updateResult = userService.updateUser(addResult);
        Assert.assertNotNull(updateResult);
        Assert.assertNotNull(updateResult.getId());
        Assert.assertEquals(newName, updateResult.getName());
        Assert.assertEquals(user.getSurname(), updateResult.getSurname());
    }

    @Test
    public void testGetUser() {
        var user = new UserEntity();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");

        var addResult = userService.addUser(user);
        Assert.assertNotNull(addResult);
        Assert.assertNotNull(addResult.getId());
        Assert.assertEquals(user.getName(), addResult.getName());
        Assert.assertEquals(user.getSurname(), addResult.getSurname());

        var getResult = userService.getUser(addResult.getId());
        Assert.assertNotNull(getResult);
        Assert.assertNotNull(getResult.getId());
        Assert.assertEquals(user.getName(), getResult.getName());
        Assert.assertEquals(user.getSurname(), getResult.getSurname());
    }

    @Test
    public void testDeleteUser() {
        var user = new UserEntity();
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setAddress("Нижние низы");

        var addResult = userService.addUser(user);
        Assert.assertNotNull(addResult);
        Assert.assertNotNull(addResult.getId());
        Assert.assertEquals(user.getName(), addResult.getName());
        Assert.assertEquals(user.getSurname(), addResult.getSurname());

        var deleteResult = userService.deleteUser(addResult.getId());
        Assert.assertEquals(addResult.getId(), deleteResult);
    }
}
