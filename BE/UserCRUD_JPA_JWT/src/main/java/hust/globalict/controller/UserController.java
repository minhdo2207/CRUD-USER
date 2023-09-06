package hust.globalict.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hust.globalict.dto.UserDTO;
import hust.globalict.dto.UserInput;
import hust.globalict.entity.User;
import hust.globalict.service.IUserService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")

public class UserController {

	@Autowired
	private IUserService service;
	
	@PreAuthorize(value = "hasAuthority('ADMIN')")
	@GetMapping()
	public ResponseEntity<?> getAllUsers() {
		 try {
		        List<UserDTO> userDTOs = new ArrayList<>();

		        // Map User objects to UserDTO objects
		        service.getAllUsers().forEach(user -> {
		            UserDTO userDTO = new UserDTO();
		            userDTO.setUsername(user.getUsername());
		            userDTO.setRoles(user.getRoles());
		            userDTOs.add(userDTO);
		        });

		        if (userDTOs.isEmpty()) {
		            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		        }

		        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
		    } catch (Exception e) {
		        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUserByID(@PathVariable(name = "id") long id) {
		try {
	        User user = service.findByUserId(id);

	        if (user == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        UserDTO userDTO = new UserDTO();
	        userDTO.setUsername(user.getUsername());
            userDTO.setRoles(user.getRoles());

	        return new ResponseEntity<>(userDTO, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody UserInput dto) {
		service.createUser(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") long id, @RequestBody UserInput dto) {
		User user = dto.toEntity();
		user.setId(id);
		service.updateUser(user);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") long id) {
		service.deleteUser(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	
}
