package com.camunda.demo;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.camunda.users.Client;
import com.camunda.users.User;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@SpringBootApplication
public class Application {

	// Maintain user data...
	HashMap<String, User> users = new HashMap<>();
	HashMap<String, Client> clients = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@JobWorker(type = "saveUser")
	public User saveUser(final ActivatedJob job) {
		User newUser = null;
		System.out.println("Existing User" + users);
		try {
			// Thread.sleep(5000); // Demo purpose wait for a while
			newUser = job.getVariablesAsType(User.class);
			String id = users.size() + "";
			newUser.setId(id);
			System.out.println("Updated the User List" + newUser);
			users.put(id, newUser);
			// Thread.sleep(5000); // Demo purpose wait for a while
		} catch (Exception exception) {
			System.err.println("Failed to update the User" + exception);
		}
		return newUser;
	}

	@JobWorker(type = "sampleProcessor")
	public User sampleProcessor(final ActivatedJob job) {
		User newUser = null;
		System.out.println("Existing User" + users);
		try {
			newUser = job.getVariablesAsType(User.class);
			// String id = users.size() + "";
			// newUser.setId(id);
			System.out.println("Updated the User List" + newUser);
			// users.put(id, newUser);
		} catch (Exception exception) {
			System.err.println("Failed to update the User" + exception);
		}
		return newUser;
	}

	@JobWorker(type = "validateClientActivity")
	public Client validateClient(final ActivatedJob job) {
		Client newClient = null;
		System.out.println("Existing Client Details" + clients);
		try {
			newClient = job.getVariablesAsType(Client.class);
			// Resets the client validation states to the default
			newClient.setMessage(null);
			newClient.setValid(true);
			if (newClient.canBeSaved()) { // check the required client info exists or not
				String id = newClient.getPhone();
				if (clients.get(id) == null) { // It is a new client
					newClient.setId(id);
					System.out.println("Updated the Client List" + newClient);
					clients.put(id, newClient);
					System.out.println("Updated the existsing Clients" + clients);
				} else { // should not have duplicate client info based on phone number
					newClient.setMessage("Phone Number already exists");
					newClient.setValid(false);
				}
			}
		} catch (Exception exception) {
			System.err.println("Failed to update the Client" + exception);
		}
		return newClient;
	}

}
